package br.com.altech.rountinner.controller;

import br.com.altech.rountinner.service.UserService;
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
    public UserDTO cadastro(@RequestBody UserDTO use){
        return service.created(use);
    }
    @GetMapping
    public List<UserDTO> lista(@RequestParam(value = "nome",required = true) String nome){
        return service.list(nome);
    }
    @DeleteMapping
    public void deletar(){
        service.delete();
    }
}
