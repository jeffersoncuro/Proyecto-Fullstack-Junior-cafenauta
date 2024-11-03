package com.locales.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locales.model.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	List<Reserva> findAllByEnable(String enable);

	@Query("SELECT r FROM Reserva r WHERE r.local.id_local = :idLocal")
	Optional<List<Reserva>> findReservasByLocalId(@Param("idLocal") Long idLocal);
}
