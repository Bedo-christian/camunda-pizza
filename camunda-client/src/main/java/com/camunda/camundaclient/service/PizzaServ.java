package com.camunda.camundaclient.service;

import com.camunda.camundaclient.model.PizzaDto;
import com.camunda.camundaclient.model.PizzaResponse;

import java.util.List;

public interface PizzaServ {
    List<PizzaResponse> getAllListPizza();
    PizzaDto createPizza(PizzaDto dto);
}
