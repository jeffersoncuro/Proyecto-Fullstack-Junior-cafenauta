package com.locales.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.locales.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.locales.model.Local;
import com.locales.model.Reserva;
import com.locales.repository.LocalRepository;
import com.locales.service.LocalService;

@Service
public class LocalServiceImpl implements LocalService{
	@Autowired
	private LocalRepository repository;

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public ResponseEntity<Map<String, Object>> listarLocales() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<Local> locales = repository.findAll();
		
		if(!locales.isEmpty()) {
			respuesta.put("mensaje", "Lista de locales");
			respuesta.put("locales", locales);
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "No hay locales");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> listarLocalesPorId(Long id_local) {
		Map<String,Object> respuesta = new HashMap<>();		
		Optional<Local> locales = repository.findById(id_local);
		
		if(locales.isPresent()) {
			respuesta.put("locales", locales);
			respuesta.put("mensaje", "Busqueda correcta");
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "No se encontró un local con ID: " + id_local);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> agregarLocal(Local local) {
		Map<String,Object> respuesta = new HashMap<>();				
		repository.save(local);
		respuesta.put("locales", local);
		respuesta.put("mensaje", "Se añadio correctamente el local");
		return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);	
	}

	@Override
	public ResponseEntity<Map<String, Object>> editarLocal(Local lo, Long id_local) {
	    Map<String, Object> respuesta = new HashMap<>();
	    Optional<Local> localExiste = repository.findById(id_local);
	    
	    if (localExiste.isPresent()) {
	        Local local = localExiste.get();
			local.setDistrito(lo.getDistrito());
	        local.setDir_local(lo.getDir_local());
	        local.setTel_local(lo.getTel_local());
	        local.setEmail_local(lo.getEmail_local());
	        local.setHorario_apertura(lo.getHorario_apertura());
	        local.setHorario_cierre(lo.getHorario_cierre());
	        local.setEnable(lo.getEnable());
	        repository.save(local);
	        respuesta.put("locales", local);
	        respuesta.put("mensaje", "Datos del local modificado");
	        return ResponseEntity.ok(respuesta);
	    } else {
	        respuesta.put("mensaje", "Sin registros con ID: " + id_local);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	    }

	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarLocalEnable(Long id_local) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Local> localExiste = repository.findById(id_local);

		if (localExiste.isPresent()) {
			Local local = localExiste.get();
			Optional<List<Reserva>> reservas = reservaRepository.findReservasByLocalId(id_local);

			if (reservas.isPresent()) {
				for (Reserva reserva : reservas.get()) {
					reserva.setEnable("N");
					reservaRepository.save(reserva);
				}
			}
			local.setEnable("N");
			repository.save(local);

			respuesta.put("mensaje", "Local y reservas vinculados deshabilitados correctamente");
			return ResponseEntity.ok(respuesta);
		} else {
			respuesta.put("mensaje", "No se encontró un local con el ID: " + id_local);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> listarLocalesEnable() {
	    Map<String, Object> respuesta = new HashMap<>();
	    List<Local> locales = repository.findAllByEnable("S");

	    if (!locales.isEmpty()) {
	        respuesta.put("mensaje", "Lista de locales disponibles");
	        respuesta.put("locales", locales);
	        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
	    } else {
	        respuesta.put("mensaje", "No existen locales disponibles");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	    }
	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarLocal(Long id_local) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Local> localExiste = repository.findById(id_local);
		if(localExiste.isPresent()) {
			Local local = localExiste.get();
			repository.delete(local);
			respuesta.put("mensaje", "Local eliminado correctamente");
			respuesta.put("status", HttpStatus.NO_CONTENT);
			respuesta.put("fecha", new Date());
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(respuesta);
		}else {
			respuesta.put("mensaje", "Local con Id:"+id_local+"no existe");
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
		
	}

}
