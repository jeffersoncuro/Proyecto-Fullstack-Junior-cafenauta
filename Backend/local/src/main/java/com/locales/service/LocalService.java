package com.locales.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.locales.model.Local;


public interface LocalService {
	public ResponseEntity<Map<String, Object>> listarLocales();
	public ResponseEntity<Map<String, Object>> listarLocalesPorId(Long id_local);
	public ResponseEntity<Map<String, Object>> agregarLocal(Local local);
	public ResponseEntity<Map<String, Object>> editarLocal(Local local, Long id_local);
	public ResponseEntity<Map<String, Object>> eliminarLocal(Long id_local);
	
	public ResponseEntity<Map<String, Object>> eliminarLocalEnable(Long id_local);
	public ResponseEntity<Map<String, Object>> listarLocalesEnable();

}
