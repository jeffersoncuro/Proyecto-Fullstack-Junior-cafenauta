package com.coffe.data.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.coffe.data.model.Categoria;

public interface CategoriaService {
	     public ResponseEntity<Map<String, Object>> listar_Categoria();
	     public ResponseEntity<Map<String, Object>> agregar_Categoria(Categoria categoria);
		 public ResponseEntity<Map<String, Object>> eliminar_Categoria(Long id);
}