package ru.shabanov.githab.helpingbanker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.shabanov.githab.helpingbanker.model.InternalClient;
import ru.shabanov.githab.helpingbanker.model.ExternalClient;

@Mapper
public interface ClientMapper {

    @Mappings({
            @Mapping(target = "id", expression = "java(externalClient.id())"),
            @Mapping(target = "fullName", expression = "java(externalClient.clientFirstName()+ ' ' + externalClient.clientLastName())")
    })
    InternalClient toInternal(ExternalClient externalClient);

}
