package main.java.br.com.fiap.doctorchat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.br.com.fiap.doctorchat.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}