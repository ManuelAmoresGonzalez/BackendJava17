package com.manuelamores.controller;

import com.manuelamores.dto.ProductDTO;
import com.manuelamores.model.Product;
import com.manuelamores.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;
    @Qualifier("productMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>>  readAll() throws Exception {
        List<ProductDTO> productDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Product product = service.readById(id);
         return new ResponseEntity<>(convertToDTO(product), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) throws Exception {
        Product createdProduct = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdProduct), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Product updatedProduct = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedProduct), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ProductDTO convertToDTO(Product product) {
        return mapper.map(product, ProductDTO.class);
    }


    private Product convertToEntity(ProductDTO dto) {
        return mapper.map(dto, Product.class);
    }
}
