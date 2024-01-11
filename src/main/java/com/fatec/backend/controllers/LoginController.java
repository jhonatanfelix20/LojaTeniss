package com.fatec.backend.controllers;

import java.util.List;
import java.util.Optional;

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

import com.fatec.backend.models.LoginModel;
import com.fatec.backend.repositories.LoginRepository;



@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    LoginRepository repository;

    @PostMapping("/api/cliente")
    public ResponseEntity<String> 
        inserir(@RequestBody LoginModel obj){
        repository.save(obj);
        String mensagem = "cadastro efetuado com sucesso";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/cliente")
    public ResponseEntity<String> 
        alterar(@RequestBody LoginModel obj){
        repository.save(obj);
        String mensagem = "cadastro atualizado";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<LoginModel> 
        carregar(@PathVariable int codigo){
        return repository.findById(codigo)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());  
    }

    @GetMapping("/api/cliente/lista")
    public ResponseEntity<List<LoginModel>> 
        lista(){
        List<LoginModel> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "cliente removido !";
        return ResponseEntity.ok(mensagem);    
    }
    @PostMapping("/api/cliente/login")
    public ResponseEntity<LoginModel> 
            fazerLogin(@RequestBody LoginModel obj){
        Optional<LoginModel> retorno = 
            repository.fazerLogin(obj.getEmail(),obj.getSenha());                
        if(retorno.isPresent()){
            return ResponseEntity.ok(retorno.get());
        } else {
            return ResponseEntity.ok(new LoginModel());
        }         
    }


}
