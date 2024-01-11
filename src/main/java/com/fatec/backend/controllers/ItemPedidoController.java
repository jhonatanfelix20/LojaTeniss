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

import com.fatec.backend.models.ItemPedidoModel;
import com.fatec.backend.repositories.ItemPedidoRepository;


@RestController
@CrossOrigin("origins = *")
public class ItemPedidoController {
    @Autowired
    ItemPedidoRepository repository;

    @PostMapping("/api/cesta")
    public ResponseEntity<String> 
        inserir(@RequestBody ItemPedidoModel obj){
        repository.save(obj);
        String mensagem = "Item adicionado a cesta";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/cesta")
    public ResponseEntity<String> 
        alterar(@RequestBody ItemPedidoModel obj){
        repository.save(obj);
        String mensagem = "Item atualizado na cesta";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/cesta/{codigo}")
    public ResponseEntity<ItemPedidoModel> 
        carregar(@PathVariable int codigo){
        return repository.findById(codigo)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/api/cesta/lista/{cliente}")
    public ResponseEntity<List<ItemPedidoModel>> 
        lista(){
        List<ItemPedidoModel> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/cesta/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "item removido da cesta!";
        return ResponseEntity.ok(mensagem);    
    }

}
