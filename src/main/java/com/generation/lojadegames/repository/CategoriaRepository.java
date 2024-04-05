package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.lojadegames.model.Categorias;

public interface CategoriaRepository extends JpaRepository<Categorias, Long>{
	
	public List<Categorias> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
	
}
