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

import com.locales.model.Reserva;
import com.locales.service.ReservaService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> listarReserva(){
		return reservaService.listarReserva();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> obtenerReserva(@PathVariable Long id){
		return reservaService.obtenerReservaPorId(id);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarReserva(@Valid @RequestBody Reserva reserva){
		return reservaService.agregarReserva(reserva);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> editarReserva(@RequestBody Reserva reserva, @PathVariable Long id){
		return reservaService.editarReserva(reserva, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> eliminarReserva(@PathVariable Long id){
		return reservaService.eliminarReserva(id);
	}

	@GetMapping("/enable")
	public ResponseEntity<Map<String, Object>> listarReservaEnable(){
		return reservaService.listarReservaEnable();
	}

	@PutMapping("/eliminar/{id}")
	public ResponseEntity<Map<String, Object>> eliminarReservaEnable(@PathVariable Long id){
		return reservaService.eliminarReservaEnable(id);
	}
}