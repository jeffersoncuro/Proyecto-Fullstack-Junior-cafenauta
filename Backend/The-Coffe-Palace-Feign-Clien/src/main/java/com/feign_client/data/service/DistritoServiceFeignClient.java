package com.feign_client.data.service;

import com.feign_client.data.model.Distrito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient( name = "distrito-api", url="http://localhost:8083/api/distritos" )
public interface DistritoServiceFeignClient {

    @GetMapping
    ResponseEntity<Map<String, Object>> listarDistritos();

    @GetMapping("/{id_dis}")
    ResponseEntity<Map<String, Object>> listarDistritosPorId(@PathVariable Long id_dis);

    @PostMapping
    ResponseEntity<Map<String, Object>> agregarDistrito(@RequestBody Distrito distrito);

    @PutMapping("/{id_dis}")
    ResponseEntity<Map<String, Object>> editarDistrito(@RequestBody Distrito distrito, @PathVariable Long id_dis);

}
