package com.fatec.backend.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.fatec.backend.models.LoginModel;




public interface LoginRepository 
extends JpaRepository<LoginModel, Integer>, 
JpaSpecificationExecutor<LoginModel> {
    @Query(value = "select * from cliente where email=?1 and senha=?2 ",
    nativeQuery = true)
   Optional<LoginModel> fazerLogin(String email, String senha);
    

}
