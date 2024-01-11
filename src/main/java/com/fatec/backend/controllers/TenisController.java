package com.fatec.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.backend.models.TenisModel;
import com.fatec.backend.repositories.TenisRepository;


@RestController
@CrossOrigin("origins = *")
public class TenisController {
    @Autowired
    TenisRepository repository;

    @PostMapping("/api/tenis")
    public ResponseEntity<String> 
        inserir(@RequestBody TenisModel obj){
        repository.save(obj);
        String mensagem = "tenis cadastrado com sucesso";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/tenis")
    public ResponseEntity<String> 
        alterar(@RequestBody TenisModel obj){
        repository.save(obj);
        String mensagem = "tenis atualizado";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/tenis/{codigo}")
    public ResponseEntity<TenisModel> 
        carregar(@PathVariable int codigo){
        return repository.findById(codigo)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/tenis/nome/{nome}")
    public ResponseEntity<TenisModel>
    carregarPorNome(@PathVariable String nome){
        return repository.findByNome(nome)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/tenis/lista")
    public ResponseEntity<List<TenisModel>> 
        lista(){
        List<TenisModel> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/tenis/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "tenis removido!";
        return ResponseEntity.ok(mensagem);    
    }
}
