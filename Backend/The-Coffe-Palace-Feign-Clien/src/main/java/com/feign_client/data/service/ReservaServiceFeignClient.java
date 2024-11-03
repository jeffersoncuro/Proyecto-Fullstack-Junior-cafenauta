package com.feign_client.data.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.feign_client.data.model.Reserva;

@FeignClient( name = "reserva-api", url="http://localhost:8083/api/reservas" )
public interface ReservaServiceFeignClient {
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> listarReserva();
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> obtenerReservaPorId(@PathVariable Long id);
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarReserva(@RequestBody Reserva reserva);
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> editarReserva(@RequestBody Reserva reserva, @PathVariable Long id);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> eliminarReserva(@PathVariable Long id);
	
	@GetMapping("/enable")
	public ResponseEntity<Map<String, Object>> listarReservaEnable();
	
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<Map<String, Object>> eliminarReservaEnable(@PathVariable Long id);

}
