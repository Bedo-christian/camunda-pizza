package com.camunda.camundaclient.mapper;

import com.camunda.camundaclient.entity.Commande;
import com.camunda.camundaclient.model.CommandeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);
    Commande dtoToEntity(CommandeDto commandeDto);
    CommandeDto entityToDto(Commande commande);
    void updateEntityFromDto (CommandeDto dto, @MappingTarget Commande commande);

}
