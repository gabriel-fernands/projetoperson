package br.com.altech.rountinner.service;

import br.com.altech.rountinner.entity.User;
import br.com.altech.rountinner.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User created(User dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<User> list(String nome) {
        return repository.findByNome(nome);

    }
}
