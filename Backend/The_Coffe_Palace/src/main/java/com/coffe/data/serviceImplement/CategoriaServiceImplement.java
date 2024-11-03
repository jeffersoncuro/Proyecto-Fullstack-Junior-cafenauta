package com.coffe.data.serviceImplement;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coffe.data.model.Categoria;
import com.coffe.data.repository.CategoriaRepository;
import com.coffe.data.service.CategoriaService;

@Service
public class CategoriaServiceImplement implements CategoriaService{
	@Autowired
	private CategoriaRepository cats;
	
	@Override
	public ResponseEntity<Map<String, Object>> listar_Categoria() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<Categoria> categoria = cats.findAll();
		
		if(!categoria.isEmpty()) {
			respuesta.put("mensaje", "Lista de Categoria");
			respuesta.put("estudiantes", categoria);
			respuesta.put("status", HttpStatus.OK);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		}else {
			respuesta.put("mensaje", "No existen registros");
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
		
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> agregar_Categoria(Categoria categoria) {
		Map<String,Object> respuesta = new HashMap<>();	
		cats.save(categoria);
		
			respuesta.put("categorias", categoria);
			respuesta.put("mensaje", "Se añadio Correctamente la categoria");
			respuesta.put("status", HttpStatus.CREATED);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);

	}
	
	@Override
	public ResponseEntity<Map<String, Object>> eliminar_Categoria(Long id) {
		Map<String,Object> respuesta = new HashMap<>();	
		Optional<Categoria> categoriaExiste = cats.findById(id);
		
		if(categoriaExiste.isPresent()) {
			Categoria categoria = categoriaExiste.get();
			cats.delete(categoria);
			respuesta.put("mensaje", "Eliminado Correctamente");
			respuesta.put("status", HttpStatus.NO_CONTENT);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(respuesta);
		}
		else {
			respuesta.put("mensaje", "Sin registro de ID " + id);
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}

	}
	
}
