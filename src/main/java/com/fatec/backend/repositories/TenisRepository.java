package com.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fatec.backend.models.TenisModel;

import java.util.Optional;

public interface TenisRepository extends JpaRepository<TenisModel, Integer>, 
JpaSpecificationExecutor<TenisModel> {

    Optional<TenisModel> findByNome(String nome);
}
