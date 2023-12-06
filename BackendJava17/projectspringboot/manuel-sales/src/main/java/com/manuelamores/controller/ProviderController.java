package com.manuelamores.controller;

import com.manuelamores.dto.ProviderDTO;
import com.manuelamores.model.Provider;
import com.manuelamores.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final IProviderService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<ProviderDTO>>  readAll() throws Exception {
        List<ProviderDTO> providerDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(providerDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProviderDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Provider provider = service.readById(id);
         return new ResponseEntity<>(convertToDTO(provider), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> create(@RequestBody ProviderDTO dto) throws Exception {
        Provider createdProvider = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdProvider), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProviderDTO> update(@RequestBody ProviderDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Provider updatedProvider = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedProvider), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ProviderDTO convertToDTO(Provider provider) {
        return mapper.map(provider, ProviderDTO.class);
    }

    private Provider convertToEntity(ProviderDTO dto) {
        return mapper.map(dto, Provider.class);
    }
}
