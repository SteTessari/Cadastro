package com.example.cadastro.service;

import com.example.cadastro.model.Pessoa;
import com.example.cadastro.repositories.CadastroRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRespository cadastroRespository;


}
