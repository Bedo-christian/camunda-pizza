package com.camunda.camundaclient.dao;

import com.camunda.camundaclient.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeDao extends JpaRepository<Commande,Integer> {

    List<Commande> findByStatus(String status);
}
