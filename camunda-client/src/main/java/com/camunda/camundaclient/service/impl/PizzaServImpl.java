package com.camunda.camundaclient.service.impl;

import com.camunda.camundaclient.dao.PizzaDao;
import com.camunda.camundaclient.entity.Client;
import com.camunda.camundaclient.entity.Pizza;
import com.camunda.camundaclient.mapper.PizzaMapper;
import com.camunda.camundaclient.model.ClientResponse;
import com.camunda.camundaclient.model.PizzaDto;
import com.camunda.camundaclient.model.PizzaResponse;
import com.camunda.camundaclient.service.PizzaServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServImpl implements PizzaServ {
    private PizzaMapper mapper;
    private PizzaDao dao;

    public PizzaServImpl(PizzaMapper mapper, PizzaDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }

    Logger logger = LoggerFactory.getLogger(PizzaServImpl.class);

    /**
     * GEt ALL list Pizza
     * @return
     */
    @Override
    public List<PizzaResponse> getAllListPizza() {
        logger.info("trying to get All pizza disponible");
        List<Pizza> pizzaList = dao.findAll();
        List<PizzaResponse> repList = new ArrayList<>();
        for (Pizza pz: pizzaList){
            repList.add(mapper.entityToDto(pz));
        }
        return repList;
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public PizzaDto createPizza(PizzaDto dto) {
        logger.info("trying to create PIZZA");
        dao.save(mapper.dtoToEntity(dto));
        return dto;
    }
}
