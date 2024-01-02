package com.manuelamores.controller;

import com.manuelamores.dto.SaleDTO;
import com.manuelamores.model.Sale;
import com.manuelamores.service.ISaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final ISaleService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<SaleDTO>>  readAll() throws Exception {
        List<SaleDTO> saleDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(saleDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SaleDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Sale sale = service.readById(id);
         return new ResponseEntity<>(convertToDTO(sale), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@Valid  @RequestBody SaleDTO dto) throws Exception {
        Sale createdSale = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdSale), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SaleDTO> update(@Valid @RequestBody SaleDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Sale updatedSale = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedSale), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private SaleDTO convertToDTO(Sale sale) {
        return mapper.map(sale, SaleDTO.class);
    }

    private Sale convertToEntity(SaleDTO dto) {
        return mapper.map(dto, Sale.class);
    }
}
