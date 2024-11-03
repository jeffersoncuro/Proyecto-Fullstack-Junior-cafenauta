package com.feign_client.data.controller;

import com.feign_client.data.model.Local;
import com.feign_client.data.service.LocalServiceFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/locales")
@CrossOrigin(origins = "http://localhost:4200")
public class LocalController {

    @Autowired
    private LocalServiceFeignClient service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listar(){
        return service.listarLocales();
    }

    @GetMapping("/{id_local}")
    public ResponseEntity<Map<String, Object>> listaPorID(@PathVariable Long id_local){
        return service.listarLocalesPorId(id_local);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> agregar(@RequestBody Local local){
        return service.agregarLocal(local);
    }

    @PutMapping("/{id_local}")
    public ResponseEntity<Map<String, Object>> editar(@RequestBody Local local,@PathVariable Long id_local){
        return service.editarLocal(local,id_local);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Long id_local){
        return service.eliminarLocal(id_local);
    }

    @GetMapping("/enable")
    public ResponseEntity<Map<String, Object>> listaPorEnable(){
        return service.listarLocalesEnable();
    }

    @PutMapping("/enable/{id_local}")
    public ResponseEntity<Map<String, Object>> eliminarPorEnable(@PathVariable Long id_local){
        return service.eliminarPorEnable(id_local);
    }
}
