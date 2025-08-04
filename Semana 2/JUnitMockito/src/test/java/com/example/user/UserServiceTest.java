package com.example.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenAnEmailNotTaken_whenRegisteringUser_thenUserIsRegistered() {

        User user = new User(1L, "Juan", "juancarlosandovalb8@example.com");

        when(userRepository.findByEmail("juancarlosandovalb8@example.com")).thenReturn(Optional.empty());

        boolean result = userService.registerUser(user);

        assertTrue(result);
        verify(userRepository).save(user);
    }

    @Test
    void givenAnExistingEmail_whenRegisteringUser_thenUserIsNotRegistered() {

        User user = new User(1L, "Carlos", "carlos@example.com");

        when(userRepository.findByEmail("carlos@example.com"))
                .thenReturn(Optional.of(user));

        // Act
        boolean result = userService.registerUser(user);

        // Assert
        assertFalse(result);
        verify(userRepository, never()).save(any());
    }

}