package com.camunda.camundaclient.mapper;

import com.camunda.camundaclient.entity.Commande;
import com.camunda.camundaclient.entity.Pizza;
import com.camunda.camundaclient.model.CommandeDto;
import com.camunda.camundaclient.model.PizzaDto;
import com.camunda.camundaclient.model.PizzaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PizzaMapper {
    PizzaMapper INSTANCE = Mappers.getMapper(PizzaMapper.class);
    Pizza dtoToEntity(PizzaDto dto);
    PizzaResponse entityToDto(Pizza commande);
    void updateEntityFromDto (PizzaDto dto, @MappingTarget Pizza pizza);

}
