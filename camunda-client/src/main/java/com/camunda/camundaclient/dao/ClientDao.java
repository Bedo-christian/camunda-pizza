package com.camunda.camundaclient.dao;

import com.camunda.camundaclient.entity.Client;
import com.camunda.camundaclient.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client,Integer> {
}
