package com.locales.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locales.model.Distrito;
import com.locales.service.DistritoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/distritos")
public class DistritoController {
	@Autowired
	private DistritoService service;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> listar(){
		return service.listarDistritos();
	}
	
	@GetMapping("/{id_dis}")
	public ResponseEntity<Map<String, Object>> listaPorID(@PathVariable Long id_dis){
		return service.listarDistritosPorId(id_dis);
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregar(@Valid @RequestBody Distrito distrito){
		return service.agregarDistrito(distrito);
	}
	
	@PutMapping("/{id_dis}")
	public ResponseEntity<Map<String, Object>> editar(@RequestBody Distrito distrito,@PathVariable Long id_dis){
		return service.editarDistrito(distrito,id_dis);
	}
}
