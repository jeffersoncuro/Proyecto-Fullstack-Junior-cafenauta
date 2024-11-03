package com.locales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locales.model.Distrito;


@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long>{
}
