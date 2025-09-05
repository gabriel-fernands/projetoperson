package br.com.altech.rountinner.service;

import br.com.altech.rountinner.entity.UserDTO;
import br.com.altech.rountinner.exception.UserNotFoudException;
import br.com.altech.rountinner.mapper.UserMapper;
import br.com.altech.rountinner.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO created(UserDTO dto) {
        return Optional.ofNullable(dto)
                .map(UserMapper::toEntity)
                .map(repository::save)
                .map(UserMapper::toDTO)
                .orElseThrow(()-> new UserNotFoudException("usuario não encontrado!"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<UserDTO> list(String nome) {
        return repository.findByNome(nome)
                .stream().map(UserMapper::toDTO)
                .toList();

    }
}
