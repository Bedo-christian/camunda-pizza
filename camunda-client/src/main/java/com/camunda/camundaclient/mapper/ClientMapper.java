package com.camunda.camundaclient.mapper;

import com.camunda.camundaclient.entity.Client;
import com.camunda.camundaclient.model.ClientDto;
import com.camunda.camundaclient.model.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client dtoToEntity(ClientDto dto);
    ClientResponse entityToDto(Client client);
    void updateEntityFromDto (ClientDto dto, @MappingTarget Client client);

}
