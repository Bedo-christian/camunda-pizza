package com.camunda.camundaclient.dao;

import com.camunda.camundaclient.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeDao extends JpaRepository<Commande,Integer> {
}
