package com.esi.msauth.repository;

import com.esi.msauth.Entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {


    Inscription findTopByOrderByIdDesc();
}
