package com.esi.msauth.controllers;



import com.esi.msauth.Entities.*;
import com.esi.msauth.repository.*;
import jdk.internal.dynalink.support.NameCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

   

    @Autowired
    private InscritsRepository inscritsRepository;
    @Autowired
    private MahremRepository mahremRepository;
    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public  @ResponseBody
    Adresse addNewAdresse(@RequestParam   Long id, String wilaya, String commune)
    {
        Adresse a = new Adresse();
        a.setId(id);
         a.setWilaya(wilaya);
        a.setCommune(commune);
        return adresseRepository.save(a);

    }
    public  @ResponseBody
    Mahrem addNewMahrem(@RequestParam  Long Enum, String Nom, String Prenom,
                        String Lieu, String Email, Long Num,
                        String sexe, Date Daten, Adresse adresse){
        Mahrem mahrem = new Mahrem();
        mahrem.setEnummahrem(Enum);
        mahrem.setNommahrem(Nom);
        mahrem.setPrenommahrem(Prenom);
        mahrem.setLieumahrem(Lieu);
        mahrem.setEmailmahrem(Email);
        mahrem.setNummahrem(Num);
        mahrem.setSexemahrem(sexe);
        mahrem.setDatenmahrem(Daten);
        mahrem.setAdressemahrem(adresse);

       return mahremRepository.save(mahrem);

    }

    @PostMapping(path = "/add")
    public  @ResponseBody String addNewInscrit (@RequestParam  Long Enum, String Nom, String Prenom,
                                                String Lieu, String Email, Long Num,
                                                String sexe, Date Daten, int inscriptions,Adresse adresse, Mahrem mahrem )
    {

        Inscrits p = new Inscrits();
        p.setEnum(Enum);
        p.setNom(Nom);
        p.setEmail(Email);
        p.setPrenom(Prenom);
        p.setDaten(Daten);
        p.setLieu(Lieu);
        p.setNum(Num);
        p.setSexe(sexe);
        p.setInscriptions(inscriptions);
        p.setAdresse(adresse);
        p.setMahrem(mahrem);

        inscritsRepository.save(p);
        return "saved";


    }


    @GetMapping(path = "/")
    public String hello(){
        return "Hello";
    }


    @GetMapping(path = "/inscrire")
    public  String inscrire(){
        return  "inscrire";
    }

    @GetMapping(path = "/all")
    public  @ResponseBody Iterable<Inscrits> getAllInscrits(){
        return inscritsRepository.findAll();
    }


    @GetMapping("/list")
    private String getAll(Model model){
        model.addAttribute("inscrits",inscritsRepository.findAll());
        return "list";
    }


    @GetMapping(path = {"/add", "edit/{id}"})
    private String addForm(@PathVariable("id") Optional<Long> id, Model model){
        if(id.isPresent()){
            model.addAttribute("mahrem",mahremRepository.findById(id.get()));

            model.addAttribute("inscrits", inscritsRepository.findById(id.get()));
            model.addAttribute("adresse",adresseRepository.findById(id.get()));
        }else{

            model.addAttribute("inscrits", new Inscrits());
            model.addAttribute("adresse", new Adresse());
            model.addAttribute("mahrem", new Mahrem());
        }
        return "inscrire";
    }

    @PostMapping("/addEdit")
    private String insert(Inscrits inscrits,Mahrem mahrem,Adresse adresse){
        if(inscrits.getEnum() == null){

            inscritsRepository.save(inscrits);
            mahremRepository.save(mahrem);
            adresseRepository.save(adresse);
        }else{
             Adresse a ;

            int randomWithMathRandom = (int) ((Math.random() * (7 - 0)) + 0);

            inscrits.setInscriptions(randomWithMathRandom);
            a = addNewAdresse(null,adresse.getWilaya(),adresse.getCommune());
               if (inscrits.getSexe().equals("femme")){
                  Mahrem m = new Mahrem();

                  m=addNewMahrem(mahrem.getEnummahrem(),mahrem.getNommahrem(),mahrem.getPrenommahrem(),mahrem.getLieumahrem(),mahrem.getEmailmahrem(),mahrem.getNummahrem(),"homme", mahrem.getDatenmahrem(),a);
                  addNewInscrit(inscrits.getEnum(),inscrits.getNom(),inscrits.getPrenom(),inscrits.getLieu(),inscrits.getEmail(),inscrits.getNum(),inscrits.getSexe(),inscrits.getDaten(),randomWithMathRandom,a,m);
              }
              else {
                   addNewInscrit(inscrits.getEnum(),inscrits.getNom(),inscrits.getPrenom(),inscrits.getLieu(),inscrits.getEmail(),inscrits.getNum(),inscrits.getSexe(),inscrits.getDaten(),randomWithMathRandom,a,null);

              }


           /* if(inscritsOptional.isPresent()){

                Inscrits editInscrits = inscritsOptional.get();
                editInscrits.setEnum(inscrits.getEnum());
                editInscrits.setEnum(inscrits.getEnum());
                editInscrits.setNom(inscrits.getNom());
                editInscrits.setPrenom(inscrits.getPrenom());
                editInscrits.setLieu(inscrits.getLieu());
                editInscrits.setEmail(inscrits.getEmail());
                editInscrits.setNum(inscrits.getNum());
                editInscrits.setSexe(inscrits.getSexe());
                editInscrits.setDaten(inscrits.getDaten());
                editInscrits.setAdresse(inscrits.getAdresse());

                inscritsRepository.save(editInscrits);




            }*/

        }
        return "redirect:/demo/list";
    }


    @GetMapping("/affichercandidat")
    private String affichercandidat(Model model ){

        //****************** DUCPLICATED CANDIDATS LIST *****************************//
        List<Inscrits> candidats = (List<Inscrits>) inscritsRepository.findAll();
        List<Inscrits> duplicatedCandidats = new ArrayList<>();
        int size = candidats.size();

        for (int j = 0; j < size; j++) {
                 for (int i = 0; i < candidats.get(j).getInscriptions(); i++) {
                    duplicatedCandidats.add(candidats.get(j));
                }
        }

        Collections.sort(duplicatedCandidats);

        model.addAttribute("candidats",duplicatedCandidats);

         return "candidatDupliquee";
    }

    @GetMapping("/tirage")
    private String tirage(Model model){
        //****************** DUCPLICATED CANDIDATS LIST *****************************//
        List<Inscrits> candidats = (List<Inscrits>) inscritsRepository.findAll();
        List<Inscrits> duplicatedCandidats = new ArrayList<>();
        int size = candidats.size();

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < candidats.get(j).getInscriptions(); i++) {
                duplicatedCandidats.add(candidats.get(j));
            }
        }
        List<Inscription> inscription = inscriptionRepository.findAll();
        int nmbrplace =inscription.get(0).getNmbrplace();

        List<Inscrits> pelerin = new ArrayList<>();

        Collections.sort(duplicatedCandidats);

        Collections.shuffle(duplicatedCandidats);
        Set<Role> roles = new HashSet<>();
        Role role =  new Role();
        role =  roleRepository.getRoleByName("pelerin");

        roles.add(role);


        for (int i=0;i<nmbrplace;i++){

            if (i<duplicatedCandidats.size()) {
                if(duplicatedCandidats.get(i).getSexe().equals("femme")) {
                    if (i < nmbrplace - 1){
                        nmbrplace = nmbrplace - 1;
                        pelerin.add(duplicatedCandidats.get(i));
                    }
                }
                else  {
                    pelerin.add(duplicatedCandidats.get(i));

                     userRepository.save(new User(null,duplicatedCandidats.get(i).getNom()+i, duplicatedCandidats.get(i).getPrenom(), true,
                            duplicatedCandidats.get(i).getNom(),duplicatedCandidats.get(i).getPrenom(),duplicatedCandidats.get(i).
                             getDaten(),duplicatedCandidats.get(i).getSexe(),duplicatedCandidats.get(i).getAdresse().getWilaya(),roles));
                }
                /*for (int j=0;j<duplicatedCandidats.size(); j++){
                    if ((duplicatedCandidats.get(i) == duplicatedCandidats.get(j)) && (i!=j)) {
                        duplicatedCandidats.remove(j);
                    }
                }*/
             }
        }


        model.addAttribute("pelerin",pelerin);
        return "tirage";

    }


}
