package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto clientDto){
        return clientService.create(clientDto);
    }

    @PutMapping
    public ClientDto update(@RequestBody ClientDto clientDto){
        return clientService.update(clientDto);
    }

    @GetMapping
    public ClientDto findById(@RequestParam("id") UUID id){
        return clientService.findById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") UUID id){
        clientService.delete(id);
    }
}