package com.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fatec.backend.models.PedidoModel;


public interface PedidoRepository extends JpaRepository<PedidoModel, Integer>, 
JpaSpecificationExecutor<PedidoModel>{
    
}
