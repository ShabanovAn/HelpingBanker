package ru.shabanov.githab.helpingbanker.service;


import ru.shabanov.githab.helpingbanker.model.InternalClient;

public interface BankerService {

    InternalClient getClient(Long id);

}
