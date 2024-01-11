package com.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fatec.backend.models.ItemPedidoModel;


public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Integer>, 
JpaSpecificationExecutor<ItemPedidoModel> {

}


