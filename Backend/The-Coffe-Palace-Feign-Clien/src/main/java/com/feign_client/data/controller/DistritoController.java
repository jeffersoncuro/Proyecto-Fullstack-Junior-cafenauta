package com.feign_client.data.controller;

import com.feign_client.data.model.Distrito;
import com.feign_client.data.service.DistritoServiceFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/distritos")
@CrossOrigin(origins = "http://localhost:4200")
public class DistritoController {

    @Autowired
    private DistritoServiceFeignClient service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarDistritos(){
        return service.listarDistritos();
    }

    @GetMapping("/{id_dis}")
    public ResponseEntity<Map<String, Object>> listaDistritoPorID(@PathVariable Long id_dis){
        return service.listarDistritosPorId(id_dis);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> agregarDistrito(@RequestBody Distrito distrito){
        return service.agregarDistrito(distrito);
    }

    @PutMapping("/{id_dis}")
    public ResponseEntity<Map<String, Object>> editarDistrito(@RequestBody Distrito distrito,@PathVariable Long id_dis){
        return service.editarDistrito(distrito,id_dis);
    }
}
