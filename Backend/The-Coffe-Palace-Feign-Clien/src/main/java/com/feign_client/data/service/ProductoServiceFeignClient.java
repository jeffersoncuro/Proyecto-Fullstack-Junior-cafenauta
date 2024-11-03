package com.feign_client.data.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.feign_client.data.model.Producto;

@FeignClient( name = "The-Coffe-Palace-Feign-Clien", url="http://localhost:8090/api/productos" )
public interface ProductoServiceFeignClient {

	@GetMapping
	public ResponseEntity<Map<String, Object>> getProductos();

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getProductoById(@PathVariable Long id);

	@GetMapping("/enable")
	public ResponseEntity<Map<String, Object>> getProductosEnable();

	@PostMapping
	public ResponseEntity<Map<String, Object>> addProducto(@RequestBody Producto producto);

	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> editProducto(@RequestBody Producto producto, @PathVariable Long id);

	@PutMapping("/enable/{id}")
	public ResponseEntity<Map<String, Object>> deleteProductosEnable(@PathVariable Long id);
}
