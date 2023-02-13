package com.example.cadastro.repositories;

import com.example.cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);

    void deleteById(Long id);
}
