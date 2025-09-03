package br.com.altech.rountinner.service;

import br.com.altech.rountinner.controller.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<UserDTO> pesisti = new ArrayList<>();

    public UserDTO created(UserDTO dto){
       pesisti.add(dto);
       return dto;
    }
    public void delete(){
        pesisti.clear();
    }
    public List<UserDTO> list(String nome){
        return pesisti.stream().toList();
    }
}
