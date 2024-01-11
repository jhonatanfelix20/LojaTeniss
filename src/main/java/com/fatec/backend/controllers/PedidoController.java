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

import com.fatec.backend.models.PedidoModel;
import com.fatec.backend.repositories.PedidoRepository;


@RestController
@CrossOrigin("origins = *")
public class PedidoController {
    @Autowired
    PedidoRepository repository;

    @PostMapping("/api/pedido")
    public ResponseEntity<String> 
        inserir(@RequestBody PedidoModel obj){
        repository.save(obj);
        String mensagem = "pedido efetuado com sucesso";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/pedido")
    public ResponseEntity<String> 
        alterar(@RequestBody PedidoModel obj){
        repository.save(obj);
        String mensagem = "pedido atualizado";
        return ResponseEntity.ok(mensagem);        
    }
    @GetMapping("/api/pedido/{codigo}")
    public ResponseEntity<PedidoModel> 
        carregar(@PathVariable int codigo){
        return repository.findById(codigo)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/api/pedido/lista")
    public ResponseEntity<List<PedidoModel>> 
        lista(){
        List<PedidoModel> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/pedido/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "pedido removido!";
        return ResponseEntity.ok(mensagem);    
    }
}
