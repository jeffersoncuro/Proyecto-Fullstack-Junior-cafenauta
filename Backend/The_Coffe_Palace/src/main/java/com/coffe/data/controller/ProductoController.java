package com.coffe.data.controller;

import java.util.Map;

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

import com.coffe.data.model.Producto;
import com.coffe.data.service.ProductoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> listarProductos(){
		return service.listar_Productos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> listarProductosId(@PathVariable Long id){
		return service.listar_Prodcutos_id(id);
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarProductos(@RequestBody Producto producto){
		return service.agregarProductos(producto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> editarProductos(@RequestBody Producto producto, @PathVariable Long id){
		return service.editarProductos(producto, id);
	}
	
	@GetMapping("/enable")
	public ResponseEntity<Map<String, Object>> listarProductosEnable(){
		return service.listar_Productos_Enable();
	}
	
	
	@PutMapping("/enable/{id}")
	public ResponseEntity<Map<String, Object>> eliminar_ProductosEnable( @PathVariable Long id){
		return service.eliminar_Productos_Enable(id);
	}
}
