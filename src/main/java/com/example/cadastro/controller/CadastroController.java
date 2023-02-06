package com.example.cadastro.controller;

import com.example.cadastro.model.Pessoa;
import com.example.cadastro.repositories.CadastroRespository;
import com.example.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/usuario")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;
    @Autowired
    private CadastroRespository cadastroRespository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarUsuario(@Validated @RequestBody Pessoa pessoa){
        cadastroRespository.save(pessoa);
        return ResponseEntity.ok("Cadastro salvo com sucesso.");
    }

    @PutMapping( "/atualizar")
    public ResponseEntity<Object> atualizarUsuario(@Validated @RequestBody Pessoa pessoa){
        cadastroRespository.save(pessoa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{idUsuario}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable Long idUsuario){
        Optional<Pessoa> pessoaOptional = cadastroRespository.findById(idUsuario);

        if (!pessoaOptional.isPresent()) {
            ResponseEntity.ok("Usuario não localizado.");
        }

        Pessoa pessoa = pessoaOptional.get();

        return ResponseEntity.ok(pessoa);
    }

    @GetMapping( "/buscar-todos")
    public ResponseEntity<Object> buscarTodos(){
        List<Pessoa> pessoaList = cadastroRespository.findAll();
        if (pessoaList.isEmpty())
            ResponseEntity.ok("Nenhum usuario encontrado.");

        return ResponseEntity.ok(pessoaList);
    }

    @DeleteMapping("/deletar/{idUsuario}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Long idUsuario){
        cadastroRespository.deleteById(idUsuario);
        return ResponseEntity.ok("Deletado com sucesso.");
    }
}
