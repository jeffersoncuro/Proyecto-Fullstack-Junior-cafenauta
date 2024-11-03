package com.feign_client.data.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feign_client.data.service.ProductoServiceFeignClient;
import com.feign_client.data.model.Producto;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	@Autowired
	private ProductoServiceFeignClient servicex;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> allProductos(){
		return servicex.getProductos();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> allProductosId(@PathVariable Long id){
		return servicex.getProductoById(id);
	}

	@GetMapping("/enable")
	public ResponseEntity<Map<String, Object>> allProductosEnable(){
		return servicex.getProductosEnable();
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarProducto(@RequestBody Producto producto){
		return servicex.addProducto(producto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> EditarProducto(@RequestBody Producto producto,@PathVariable Long id){
		return servicex.editProducto(producto,id);
	}
	
	@PutMapping("/enable/{id}")
	public ResponseEntity<Map<String, Object>> eliminarProductosEnable( @PathVariable Long id){
		return servicex.deleteProductosEnable(id);
	}
}
