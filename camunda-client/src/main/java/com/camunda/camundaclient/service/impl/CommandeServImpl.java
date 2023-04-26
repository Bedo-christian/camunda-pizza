package com.camunda.camundaclient.service.impl;

import com.camunda.camundaclient.dao.CommandeDao;
import com.camunda.camundaclient.entity.Client;
import com.camunda.camundaclient.entity.Commande;
import com.camunda.camundaclient.exception.NotFoundException;
import com.camunda.camundaclient.mapper.CommandeMapper;
import com.camunda.camundaclient.model.ClientResponse;
import com.camunda.camundaclient.model.CommandeDto;
import com.camunda.camundaclient.model.CommandeResponse;
import com.camunda.camundaclient.service.CommandeServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServImpl implements CommandeServ {

    private CommandeDao dao;
    private CommandeMapper mapper;

    public CommandeServImpl(CommandeDao dao, CommandeMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    Logger logger = LoggerFactory.getLogger(CommandeServImpl.class);

    /**enregistrer les commandes entrer par le client
     * @param dto
     * @return
     */
    @Override
    public CommandeDto saveCommande(CommandeDto dto) {
        logger.info("try to save commande");
        dao.save(mapper.dtoToEntity(dto));
        return dto;
    }

    /**
     * Recupere list commande
     * @return
     */
    @Override
    public List<CommandeResponse> getAllCommande() {
        logger.info("try to getList all order");
        List<Commande> orderList = dao.findAll();
        List<CommandeResponse> repList = new ArrayList<>();
        for (Commande order: orderList){
            repList.add(mapper.entityToDto(order));
        }

        return repList;
    }

    /**recuperation commande by status
     * @param status
     * @return
     */
    @Override
    public List<CommandeResponse> getOrderByStatus(String status) {
        logger.info("try to getList all order By Status :"+status);
        List<Commande> orderList = dao.findByStatus(status);
        List<CommandeResponse> repList = new ArrayList<>();
        for (Commande order: orderList){
            repList.add(mapper.entityToDto(order));
        }

        return repList;
    }

    /**
     * @param idCommande
     * @return
     */
    @Override
    public CommandeResponse getOrderById(int idCommande) {
        Optional<Commande> commande = dao.findById(idCommande);
        if (commande.isPresent()){
            return mapper.entityToDto(commande.get());
        }else{
            throw new NotFoundException();
        }
    }

    /**
     * @param idCommande
     * @param dto
     */
    @Override
    public void modifOrder(int idCommande, CommandeDto dto) {
        Optional<Commande> commande = dao.findById(idCommande);
        if (commande.isPresent()){
            Commande  orderEntity = commande.get();
            mapper.updateEntityFromDto(dto,orderEntity);
            dao.save(orderEntity);
        }else{
            throw new NotFoundException();
        }
    }
}
