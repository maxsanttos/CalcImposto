package com.max.calcimposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.calcimposto.model.Impostos;

public interface ImpostosRepository extends JpaRepository<Impostos, Long>{

    List<Impostos> findByUserId(Long userId);

}
