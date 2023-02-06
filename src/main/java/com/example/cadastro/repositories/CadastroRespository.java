package com.example.cadastro.repositories;

import com.example.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CadastroRespository extends JpaRepository<Pessoa, UUID> {

    Optional<Pessoa> findById(Long id);

}
