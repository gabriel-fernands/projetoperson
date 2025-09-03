package br.com.altech.rountinner.repository;

import br.com.altech.rountinner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByNome(String nome);
}
