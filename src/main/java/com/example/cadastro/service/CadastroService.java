package com.example.cadastro.service;

import com.example.cadastro.model.Pessoa;
import com.example.cadastro.repositories.CadastroRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroService {

    @Autowired
    private CadastroRespository cadastroRespository;


    public void cadastrar(Pessoa pessoa){
        cadastroRespository.save(pessoa);
    }

    public Pessoa buscar(Long id){
        Optional<Pessoa> pessoaOptional = cadastroRespository.findById(id);

        if (!pessoaOptional.isPresent())
            throw new RuntimeException("Cadastro não encontrado.");

        return pessoaOptional.get();
    }


    public void deletar(UUID id){
        cadastroRespository.deleteById(id);
    }
}
