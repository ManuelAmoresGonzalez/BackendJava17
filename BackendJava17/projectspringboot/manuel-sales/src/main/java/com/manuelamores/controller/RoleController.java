package com.manuelamores.controller;

import com.manuelamores.dto.RoleDTO;
import com.manuelamores.model.Role;
import com.manuelamores.service.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<RoleDTO>>  readAll() throws Exception {
        List<RoleDTO> roleDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RoleDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Role role = service.readById(id);
         return new ResponseEntity<>(convertToDTO(role), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> create(@Valid  @RequestBody RoleDTO dto) throws Exception {
        Role createdRole = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdRole), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RoleDTO> update(@Valid @RequestBody RoleDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Role updatedRole = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedRole), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private RoleDTO convertToDTO(Role role) {
        return mapper.map(role, RoleDTO.class);
    }


    private Role convertToEntity(RoleDTO dto) {
        return mapper.map(dto, Role.class);
    }
}
