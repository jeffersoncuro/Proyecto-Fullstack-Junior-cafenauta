package com.coffe.data.controller;

import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffe.data.model.Categoria;
import com.coffe.data.service.CategoriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/categorias")
@AllArgsConstructor
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> listarCategoria(){
		return service.listar_Categoria();
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarCategoria(@RequestBody Categoria categoria){
		return service.agregar_Categoria(categoria);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Map<String, Object>> eliminarCategoria( @PathVariable Long id){
		return service.eliminar_Categoria(id);
	}	
}
