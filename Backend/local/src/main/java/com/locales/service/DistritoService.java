package com.locales.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.locales.model.Distrito;

public interface DistritoService {
	public ResponseEntity<Map<String, Object>> listarDistritos();
	public ResponseEntity<Map<String, Object>> listarDistritosPorId(Long id_dis);
	public ResponseEntity<Map<String, Object>> agregarDistrito(Distrito distrito);
	public ResponseEntity<Map<String, Object>> editarDistrito(Distrito distrito, Long id_dis);
	public ResponseEntity<Map<String, Object>> eliminarDistrito(Long id_dis);
}