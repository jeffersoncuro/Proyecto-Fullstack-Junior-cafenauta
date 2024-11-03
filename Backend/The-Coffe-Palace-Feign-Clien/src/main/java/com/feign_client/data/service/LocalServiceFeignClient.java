package com.feign_client.data.service;

import com.feign_client.data.model.Local;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient( name = "local-api", url="http://localhost:8083/api/locales" )
public interface LocalServiceFeignClient {

    @GetMapping
    ResponseEntity<Map<String, Object>> listarLocales();

    @GetMapping("/enable")
    ResponseEntity<Map<String, Object>> listarLocalesEnable();

    @GetMapping("/{id_local}")
    ResponseEntity<Map<String, Object>> listarLocalesPorId(@PathVariable Long id_local);

    @PostMapping
    ResponseEntity<Map<String, Object>> agregarLocal(@RequestBody Local local);

    @PutMapping("/{id_local}")
    ResponseEntity<Map<String, Object>> editarLocal(@RequestBody Local local, @PathVariable Long id_local);

    @DeleteMapping("/{id_local}")
    ResponseEntity<Map<String, Object>> eliminarLocal(@PathVariable Long id_local);

    @PutMapping("/enable/{id_local}")
    ResponseEntity<Map<String, Object>> eliminarPorEnable(@PathVariable Long id_local);
}
