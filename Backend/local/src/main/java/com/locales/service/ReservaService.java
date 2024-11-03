package com.locales.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.locales.model.Reserva;

public interface ReservaService {
	public ResponseEntity<Map<String, Object>> listarReserva();
	public ResponseEntity<Map<String, Object>> obtenerReservaPorId(Long id);
	public ResponseEntity<Map<String, Object>> agregarReserva(Reserva reserva);
	public ResponseEntity<Map<String, Object>> editarReserva(Reserva reserva, Long id);
	public ResponseEntity<Map<String, Object>> eliminarReserva(Long id);
	public ResponseEntity<Map<String, Object>> listarReservaEnable();
	public ResponseEntity<Map<String, Object>> eliminarReservaEnable(Long id);
	
}
