package com.camunda.camundaclient.service;

import com.camunda.camundaclient.model.ClientDto;
import com.camunda.camundaclient.model.ClientResponse;

import java.util.List;

public interface ClientService {

    List<ClientResponse> getAllClients();
    ClientDto saveClient(ClientDto clientDto);
    ClientDto updateClient(Integer idClient, ClientDto clientDto);
    ClientResponse getClientById(Integer clientId);
    void deleteClientById(Integer clientId);
}
