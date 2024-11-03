package com.locales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locales.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{
	List<Local> findAllByEnable(String enable);

}
