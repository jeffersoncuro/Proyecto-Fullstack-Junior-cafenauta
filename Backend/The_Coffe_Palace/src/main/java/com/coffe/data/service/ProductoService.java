package com.coffe.data.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.coffe.data.model.Producto;

public interface ProductoService {
	    public ResponseEntity<Map<String, Object>> listar_Productos();

	    public ResponseEntity<Map<String, Object>> listar_Productos_Enable();
		
		public ResponseEntity<Map<String, Object>> eliminar_Productos_Enable(Long id);

		public ResponseEntity<Map<String, Object>> listar_Prodcutos_id(Long id);
		
		public ResponseEntity<Map<String, Object>> agregarProductos(Producto producto);
		
		public ResponseEntity<Map<String, Object>> editarProductos(Producto prd,Long id);
}
