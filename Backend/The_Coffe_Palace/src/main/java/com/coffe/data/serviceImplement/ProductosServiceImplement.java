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

import com.coffe.data.model.Producto;
import com.coffe.data.repository.ProductoRepository;
import com.coffe.data.service.ProductoService;

@Service
public class ProductosServiceImplement implements ProductoService{

	@Autowired
	private ProductoRepository reps;
	
	@Override
	public ResponseEntity<Map<String, Object>> listar_Productos() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<Producto> producto = reps.findAll();
		
		if(!producto.isEmpty()) {
			respuesta.put("mensaje", "Lista de Productos");
			respuesta.put("Productos", producto);
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
	public ResponseEntity<Map<String, Object>> listar_Prodcutos_id(Long id) {
		Map<String,Object> respuesta = new HashMap<>();	
		Optional<Producto> producto = reps.findById(id);
		
		if(producto.isPresent()) {
			respuesta.put("Productos", producto);
			respuesta.put("mensaje", "Busqueda Correcta");
			respuesta.put("status", HttpStatus.OK);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.ok().body(respuesta);
		}else {
			respuesta.put("mensaje", "Sin Registros de ID " + id);
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
		
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> agregarProductos(Producto producto) {
		Map<String,Object> respuesta = new HashMap<>();	
		reps.save(producto);
		
			respuesta.put("Productos", producto);
			respuesta.put("mensaje", "Se añadio Correctamente el producto");
			respuesta.put("status", HttpStatus.CREATED);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);

	}
	
	@Override
	public ResponseEntity<Map<String, Object>> editarProductos(Producto prd, Long id) {
		Map<String,Object> respuesta = new HashMap<>();	
		Optional<Producto> productoExiste = reps.findById(id);
		
		if(productoExiste.isPresent()) {
			Producto producto = productoExiste.get();
			producto.setDescripcion(prd.getDescripcion());
			producto.setNombre(prd.getNombre());
			producto.setPrecio(prd.getPrecio());
			producto.setId_categoria(prd.getId_categoria());
		    producto.setEnable(prd.getEnable());
			reps.save(producto);
			respuesta.put("Productos", producto);
			respuesta.put("mensaje", "Datos del producto Modificado");
			respuesta.put("status", HttpStatus.CREATED);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
		}
		else {
			respuesta.put("mensaje", "Sin registro de ID " + id);
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}

	}
	
	@Override
	public ResponseEntity<Map<String, Object>> eliminar_Productos_Enable(Long id) {
		Map<String,Object> respuesta = new HashMap<>();	
		Optional<Producto> productoExiste = reps.findById(id);
		
		if(productoExiste.isPresent()) {
			Producto producto = productoExiste.get();
			producto.setEnable("N");
			reps.save(producto);
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
	
	@Override
	public ResponseEntity<Map<String, Object>> listar_Productos_Enable() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<Producto> producto = reps.findAllByEnable("S");
		
		if(!producto.isEmpty()) {
			respuesta.put("mensaje", "Lista de Productos");
			respuesta.put("Productos", producto);
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
	
	
}
