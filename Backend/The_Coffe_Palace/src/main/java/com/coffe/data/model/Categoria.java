package com.coffe.data.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
@EntityListeners(AuditingEntityListener.class)
public class Categoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id_categoria;

	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;
}
