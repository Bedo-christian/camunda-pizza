package com.mandat.affecationf.service.impl;

import com.mandat.affecationf.dao.ClientDao;
import com.mandat.affecationf.entity.Client;
import com.mandat.affecationf.exception.NotFoundException;
import com.mandat.affecationf.mapper.ClientMapper;
import com.mandat.affecationf.model.ClientDto;
import com.mandat.affecationf.model.ClientResponse;
import com.mandat.affecationf.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientMapper clientMapper;
    private final ClientDao clientDao;
    public ClientServiceImpl(ClientMapper clientMapper, ClientDao clientDao){
        this.clientMapper = clientMapper;
        this.clientDao = clientDao;
    }

    @Override
    public List<ClientResponse> getAllClients() {
        logger.info("Recuperer toutes les clients");
        List<Client> clientList = clientDao.findAll();
        List<ClientResponse> repList = new ArrayList<>();
        for (Client client: clientList){
            repList.add(clientMapper.EntityToClientDto(client));
        }

        return repList;
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        logger.info("Enregistrement client");
        clientDao.save(clientMapper.dtoToClientEntity(clientDto));
        return clientDto;
    }

    @Override
    public ClientDto updateClient(Integer idClient, ClientDto clientDto) {
        Optional<Client> client = clientDao.findById(idClient);
        logger.info("mis à jour des clients");
        if (client.isPresent()){
            Client  clientEntity = client.get();
            clientMapper.updateEntityFromDto(clientDto,clientEntity);
            clientDao.save(clientEntity);
            return clientDto;
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public ClientResponse getClientById(Integer clientId) {
        Optional<Client> client = clientDao.findById(clientId);
        if (client.isPresent()){
            return clientMapper.EntityToClientDto(client.get());
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteClientById(Integer clientId) {
        clientDao.deleteById(clientId);
    }

}
