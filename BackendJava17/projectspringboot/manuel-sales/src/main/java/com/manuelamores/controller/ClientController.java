package com.manuelamores.controller;

import com.manuelamores.dto.ClientDTO;
import com.manuelamores.model.Client;
import com.manuelamores.service.IClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<ClientDTO>>  readAll() throws Exception {
        List<ClientDTO> clientDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Client client = service.readById(id);
         return new ResponseEntity<>(convertToDTO(client), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO dto) throws Exception {
        Client createdClient = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdClient), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Client updatedClient = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedClient), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ClientDTO convertToDTO(Client client) {
        return mapper.map(client, ClientDTO.class);
    }


    private Client convertToEntity(ClientDTO dto) {
        return mapper.map(dto, Client.class);
    }
}
