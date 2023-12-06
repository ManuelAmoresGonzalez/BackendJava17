package com.manuelamores.controller;

import com.manuelamores.dto.UserDTO;
import com.manuelamores.model.User;
import com.manuelamores.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>>  readAll() throws Exception {
        List<UserDTO> userDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         User user = service.readById(id);
         return new ResponseEntity<>(convertToDTO(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) throws Exception {
        User createdUser = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdUser), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto, @PathVariable ("id") Integer id) throws Exception {
        User updatedUser = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedUser), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private UserDTO convertToDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }


    private User convertToEntity(UserDTO dto) {
        return mapper.map(dto, User.class);
    }
}
