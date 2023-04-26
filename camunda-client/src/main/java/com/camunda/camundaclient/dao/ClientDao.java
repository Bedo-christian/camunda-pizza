package com.camunda.camundaclient.dao;

import com.camunda.camundaclient.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaDao extends JpaRepository<Pizza,Integer> {
}
