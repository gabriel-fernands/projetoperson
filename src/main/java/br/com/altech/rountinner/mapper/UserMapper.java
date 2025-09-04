package br.com.altech.rountinner.mapper;

import br.com.altech.rountinner.entity.User;
import br.com.altech.rountinner.entity.UserDTO;

public class UserMapper {

    public static User toEntity(UserDTO dto){
        return User.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .idade(dto.getIdade())
                .build();
    }
    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .nome(user.getNome())
                .cpf(user.getCpf())
                .idade(user.getIdade())
                .build();
    }
}
