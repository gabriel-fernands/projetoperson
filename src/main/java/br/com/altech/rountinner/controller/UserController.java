package br.com.altech.rountinner.controller;

import br.com.altech.rountinner.entity.UserDTO;
import br.com.altech.rountinner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity <UserDTO> cadastro(@RequestBody UserDTO dto){
         return ResponseEntity.status(HttpStatus.CREATED).body( service.created(dto));
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> lista(@RequestParam(value = "nome",required = true) String nome){
        return ResponseEntity.ok(service.list(nome));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
