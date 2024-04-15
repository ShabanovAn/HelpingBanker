package ru.shabanov.githab.helpingbanker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shabanov.githab.helpingbanker.mapper.ClientMapper;
import ru.shabanov.githab.helpingbanker.model.InternalClient;
import ru.shabanov.githab.helpingbanker.service.BankerServiceImpl;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    private BankerServiceImpl clientService;

    private final ClientMapper clientMapper;

    public ClientController(BankerServiceImpl clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternalClient> getClientById(@PathVariable Long id) {
        InternalClient client = clientService.getClient(id);
        return ResponseEntity.ok(client);
    }
}