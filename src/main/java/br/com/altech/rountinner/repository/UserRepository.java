package br.com.altech.rountinner.repository;

import br.com.altech.rountinner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
