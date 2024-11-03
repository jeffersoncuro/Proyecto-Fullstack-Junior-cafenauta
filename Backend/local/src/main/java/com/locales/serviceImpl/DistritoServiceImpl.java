package com.locales.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.locales.model.Distrito;
import com.locales.repository.DistritoRepository;
import com.locales.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	private DistritoRepository repository;
	
	@Override
	public ResponseEntity<Map<String, Object>> listarDistritos() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<Distrito> distritos = repository.findAll();
		
		if(!distritos.isEmpty()) {
			respuesta.put("mensaje", "Lista de distritos");
			respuesta.put("distritos", distritos);
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "No hay distritos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> listarDistritosPorId(Long id_dis) {
		Map<String,Object> respuesta = new HashMap<>();		
		Optional<Distrito> distritos = repository.findById(id_dis);
		
		if(distritos.isPresent()) {
			respuesta.put("distritos", distritos);
			respuesta.put("mensaje", "Busqueda correcta");
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "No se encontró un distrito con ID: " + id_dis);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> agregarDistrito(Distrito distrito) {
		Map<String,Object> respuesta = new HashMap<>();				
		repository.save(distrito);
		respuesta.put("distritos", distrito);
		respuesta.put("mensaje", "Se añadio correctamente el distrito");
		return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);	
	}

	@Override
	public ResponseEntity<Map<String, Object>> editarDistrito(Distrito dis, Long id_dis) {
		Map<String, Object> respuesta = new HashMap<>();
	    Optional<Distrito> distritoExiste = repository.findById(id_dis);
	    
	    if (distritoExiste.isPresent()) {
	    	Distrito distrito = distritoExiste.get();
	    	distrito.setNom_dis(dis.getNom_dis());
	        repository.save(distrito);
	        respuesta.put("distritos", distrito);
	        respuesta.put("mensaje", "Datos del distrito modificado");
	        return ResponseEntity.ok(respuesta);
	    } else {
	        respuesta.put("mensaje", "Sin registros con ID: " + id_dis);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	    }
	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarDistrito(Long id_dis) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Distrito> distritoExiste = repository.findById(id_dis);
		if (distritoExiste.isPresent()) {
			Distrito distrito = distritoExiste.get();
			repository.delete(distrito);
			respuesta.put("mensaje", "Eliminado correctamente");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(respuesta);
		} else {
			respuesta.put("mensaje", "Sin registros con ID: " + id_dis);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}
}
