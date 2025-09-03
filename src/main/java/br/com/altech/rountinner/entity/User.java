package br.com.altech.rountinner.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users") // define o nome da tabela no Postgres
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrement no Postgres
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    @Column(nullable = false, length = 255)
    private String nome;

    @Size(max = 3, message = "A idade deve ter no máximo 3 caracteres")
    @Column(length = 3)
    private String idade;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(max = 14, message = "CPF deve estar no formato XXX.XXX.XXX-XX")
    @Column(unique = true, length = 14, nullable = false)
    private String cpf;
}
