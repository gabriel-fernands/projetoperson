package br.com.altech.rountinner.service;

import br.com.altech.rountinner.entity.User;
import br.com.altech.rountinner.entity.UserDTO;
import br.com.altech.rountinner.exception.UserNotFoudException;
import br.com.altech.rountinner.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    private User user;
    private UserDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User(1L, "Eliza", "4", "1323236");
        dto = new UserDTO(1L, "Eliza", "4", "1323236");
    }

    @Test
    void created_DeveSalvarUsuarioERetornarDTO() {
        // Arrange
        when(repository.save(any(User.class))).thenReturn(user);

        // Act
        UserDTO result = service.created(dto);

        // Assert
        assertNotNull(result);
        assertEquals(dto.getNome(), result.getNome());
        assertEquals(dto.getCpf(), result.getCpf());
        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void created_DeveLancarExcecaoQuandoMapperRetornarNull() {
        // Arrange
        UserDTO dtoNull = null;

        // Act & Assert
        assertThrows(UserNotFoudException.class, () -> service.created(dtoNull));
    }

    @Test
    void delete_DeveChamarRepositoryDeleteById() {
        // Act
        service.delete(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void list_DeveRetornarListaDeUsuarios() {
        // Arrange
        when(repository.findByNome("Eliza")).thenReturn(List.of(user));

        // Act
        List<UserDTO> result = service.list("Eliza");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Eliza", result.get(0).getNome());
        verify(repository, times(1)).findByNome("Eliza");
    }

    @Test
    void list_DeveRetornarListaVaziaQuandoNaoEncontrarUsuarios() {
        // Arrange
        when(repository.findByNome("Inexistente")).thenReturn(List.of());

        // Act
        List<UserDTO> result = service.list("Inexistente");

        // Assert
        assertTrue(result.isEmpty());
        verify(repository, times(1)).findByNome("Inexistente");
    }
}

