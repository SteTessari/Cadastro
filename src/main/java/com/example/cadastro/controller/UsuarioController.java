package com.example.cadastro.controller;

import com.example.cadastro.model.Usuario;
import com.example.cadastro.repositories.UsuarioRespository;
import com.example.cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRespository usuarioRespository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarUsuario(@Validated @RequestBody Usuario usuario){
        usuarioRespository.save(usuario);
        return ResponseEntity.ok("Cadastro salvo com sucesso.");
    }

    @PutMapping( "/atualizar")
    public ResponseEntity<Object> atualizarUsuario(@Validated @RequestBody Usuario usuario){
        usuarioRespository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{idUsuario}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable Long idUsuario){
        Optional<Usuario> pessoaOptional = usuarioRespository.findById(idUsuario);

        if (!pessoaOptional.isPresent()) {
            ResponseEntity.ok("Usuario não localizado.");
        }

        Usuario usuario = pessoaOptional.get();

        return ResponseEntity.ok(usuario);
    }

    @GetMapping( "/buscar-todos")
    public ResponseEntity<Object> buscarTodos(){
        List<Usuario> usuarioList = usuarioRespository.findAll();
        if (usuarioList.isEmpty())
            ResponseEntity.ok("Nenhum usuario encontrado.");

        return ResponseEntity.ok(usuarioList);
    }

    @DeleteMapping("/deletar/{idUsuario}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Long idUsuario){
        usuarioRespository.deleteById(idUsuario);
        return ResponseEntity.ok("Deletado com sucesso.");
    }
}
