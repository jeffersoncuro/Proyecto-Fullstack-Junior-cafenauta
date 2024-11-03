package com.feign_client.data.model;

import lombok.Data;

@Data
public class Producto {
	private long id_producto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Categoria id_categoria;
	private String enable;
}
