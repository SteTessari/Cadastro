package com.example.cadastro.controller;

import com.example.cadastro.model.Pessoa;
import com.example.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RestController
@RequestMapping("/cadastrar-usuario")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping("/inserir")
    public ResponseEntity<Object> cadastrarUsuario(@Validated @RequestBody Pessoa pessoa){
        cadastroService.cadastrar(pessoa);
        return ResponseEntity.ok("Cadastro salvo com sucesso.");
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<Object> atualizarUsuario(@Validated @RequestBody Pessoa pessoa){
        cadastroService.cadastrar(pessoa);
        return ResponseEntity.ok("Cadastro salvo com sucesso.");
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable Long id){
        Pessoa pessoa = cadastroService.buscar(id);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable UUID id){
        cadastroService.deletar(id);
        return ResponseEntity.ok("Deletado com sucesso.");
    }
}
