package com.camunda.camundaclient.service;

import com.camunda.camundaclient.model.CommandeDto;
import com.camunda.camundaclient.model.CommandeResponse;

import java.util.List;

public interface CommandeServ {
    CommandeDto saveCommande(CommandeDto dto);
    List<CommandeResponse> getAllCommande();
    List<CommandeResponse> getOrderByStatus(String status);
    CommandeResponse getOrderById(int idCommande);
    void modifOrder(int idCommande, CommandeDto dto);
}
