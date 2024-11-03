package com.locales.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.locales.model.Reserva;
import com.locales.repository.ReservaRepository;
import com.locales.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public ResponseEntity<Map<String, Object>> listarReserva() {
		Map<String, Object> respuesta = new HashMap<>();
		List<Reserva> reservas = reservaRepository.findAll();

		if (!reservas.isEmpty()) {
			respuesta.put("mensaje", "Lista de reservas disponibles");
			respuesta.put("reservas", reservas);
			respuesta.put("status", HttpStatus.OK);
			respuesta.put("fecha", new Date());
			return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		}else {
			respuesta.put("mensaje", "No hay reservas registradas");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}


	}

	@Override
	public ResponseEntity<Map<String, Object>> obtenerReservaPorId(Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Reserva> reservas = reservaRepository.findById(id);
		if (reservas.isPresent()) {
			respuesta.put("reservas", reservas);
			respuesta.put("mensaje", "Reserva encontrada");
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "Reserva no encontrada");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}

	}

	@Override
	public ResponseEntity<Map<String, Object>> agregarReserva(Reserva reserva) {
		Map<String,Object> respuesta = new HashMap<>();
		reservaRepository.save(reserva);
		respuesta.put("reservas", reserva);
		respuesta.put("mensaje","Reserva guardada correctamente");
		respuesta.put("fecha", new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
	}

	@Override
	public ResponseEntity<Map<String, Object>> editarReserva(Reserva reserva, Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Reserva> reservaExiste = reservaRepository.findById(id);

		if (reservaExiste.isPresent()) {
			Reserva reservaEdit = reservaExiste.get();
			reservaEdit.setNomRes(reserva.getNomRes());
			reservaEdit.setApeRes(reserva.getApeRes());
			reservaEdit.setEmailRes(reserva.getEmailRes());
			reservaEdit.setTelRes(reserva.getTelRes());
			reservaEdit.setFechaReserva(reserva.getFechaReserva());
			reservaEdit.setHoraReserva(reserva.getHoraReserva());
			reservaEdit.setComensales(reserva.getComensales());
			reservaRepository.save(reservaEdit);
			respuesta.put("reservas", reservaEdit);
			respuesta.put("mensaje", "Reserva modificada con éxito");
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "Sin registro de reserva indicada");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}

	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarReserva(Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Reserva> reservaExiste = reservaRepository.findById(id);
		if (reservaExiste.isPresent()) {
			Reserva reserva = reservaExiste.get();
			reservaRepository.delete(reserva);
			respuesta.put("mensaje", "Reserva eliminada correctamente");
			respuesta.put("status", HttpStatus.NO_CONTENT);
			respuesta.put("fecha", new Date());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(respuesta)	;
		} else {
			respuesta.put("mensaje", "Reserva no encontrada");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}


	@Override
	public ResponseEntity<Map<String, Object>> listarReservaEnable() {
		Map<String, Object> respuesta = new HashMap<>();
		List<Reserva> reservasEnable = reservaRepository.findAllByEnable("S");
		if (!reservasEnable.isEmpty()) {
			respuesta.put("mensaje", "Lista de reservas disponibles");
			respuesta.put("reservas", reservasEnable);
			return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		}else {
			respuesta.put("Mensaje","No hay reservas disponibles");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}

	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarReservaEnable(Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Reserva> reservaDel = reservaRepository.findById(id);
		if (reservaDel.isPresent()) {
			Reserva reservaD = reservaDel.get();
			reservaD.setEnable("N");
			reservaRepository.save(reservaD);
			respuesta.put("mensaje", "Reserva eliminada");
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.put("mensaje", "No se encontró registro de reserva indicada");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}

	}

}
