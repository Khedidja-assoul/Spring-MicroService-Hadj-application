package com.esi.msauth.controllers;

import com.esi.msauth.Entities.DossierMedicale;
import com.esi.msauth.Entities.Inscription;
import com.esi.msauth.Entities.Role;
import com.esi.msauth.Entities.User;
import com.esi.msauth.repository.DossierMedicaleRepository;
import com.esi.msauth.repository.InscriptionRepository;
import com.esi.msauth.repository.RoleRepository;
import com.esi.msauth.repository.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.View;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Controller
public class Controller {
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private DossierMedicaleRepository dossierMedicaleRepository;




    @PostMapping("/lancerInscription")
    private String lancer(Inscription inscription,Model model){
        inscriptionRepository.save(new Inscription(null,inscription.getDated(),inscription.getDatef(),inscription.getNmbrplace()));
        model.addAttribute("inscription",inscriptionRepository.findById((long) 41));
         return "home";
    }
    @GetMapping("/openinscription")
    private String open(Model model){
        model.addAttribute("inscription", new Inscription());
                return "openInscription";
    }

    @PostMapping("/addMedecin")
    private String addMedecin(User user,Model model){
          Set<Role> roles = new HashSet<>();
            Role role =  new Role();
                role =  roleRepository.getRoleByName("medecin");

                //Role e = new Role();
                /*e.setId(role.get().getId());
                e.setName(role.get().getName());*/
          roles.add(role);

         userRepository.save(new User(user.getId(),user.getUsername(),user.getPassword(), true,
                user.getNom(),user.getPrenom(),user.getDaten(),user.getSpecialite(),user.getSexe(),user.getAdresse(),roles));

        model.addAttribute("inscription", inscriptionRepository.findAll());
        return "home";
    }


    @GetMapping("/create")
    private  String create(Model model){

        model.addAttribute("users", new User());
        return "creerMedecin";
    }

    @GetMapping("/")
    private  String home(Model model){
        model.addAttribute("inscription", inscriptionRepository.findAll());
        return  "home";
    }
    @GetMapping("/list")
    private String getAll(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "index";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");

        return "home";
    }

   // @PostMapping("/compte")
    public void allercompte(Authentication authentication){


        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("admin"));

         if (hasUserRole)  {
            admin();
         }

    }

   



    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
