package com.coffe.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffe.data.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
 
	List<Producto> findAllByEnable(String enable);
}
