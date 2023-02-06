package com.example.cadastro.repositories;

import com.example.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroRespository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);

    void deleteById(Long id);
}
