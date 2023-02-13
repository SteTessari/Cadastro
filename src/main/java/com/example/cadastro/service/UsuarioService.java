package com.example.cadastro.service;

import com.example.cadastro.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;


}
