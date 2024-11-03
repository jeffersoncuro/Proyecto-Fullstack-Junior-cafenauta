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

import com.locales.model.Local;
import com.locales.service.LocalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/locales")
public class LocalController {
	@Autowired
	private LocalService service;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> listar(){
		return service.listarLocales();
	}

	@GetMapping("/{id_local}")
	public ResponseEntity<Map<String, Object>> listaPorID(@PathVariable Long id_local){
		return service.listarLocalesPorId(id_local);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> agregar(@Valid @RequestBody Local local){
		return service.agregarLocal(local);
	}

	@PutMapping("/{id_local}")
	public ResponseEntity<Map<String, Object>> editar(@RequestBody Local local,@PathVariable Long id_local){
		return service.editarLocal(local,id_local);
	}

	@GetMapping("/enable")
	public ResponseEntity<Map<String, Object>> listaPorEnable(){
		return service.listarLocalesEnable();
	}

	@PutMapping("/enable/{id_local}")
	public ResponseEntity<Map<String, Object>> eliminarPorEnable(@PathVariable Long id_local){
		return service.eliminarLocalEnable(id_local);
	}
}