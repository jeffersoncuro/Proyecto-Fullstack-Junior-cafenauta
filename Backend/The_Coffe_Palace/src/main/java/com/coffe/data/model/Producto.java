package com.coffe.data.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "producto")
@EntityListeners(AuditingEntityListener.class)
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private long id_producto;

	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "precio", nullable = false)
	private Double precio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;

	@Column(name = "enable", length = 1)
	private String enable;
}
