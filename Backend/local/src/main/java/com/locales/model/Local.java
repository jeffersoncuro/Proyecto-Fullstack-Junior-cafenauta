package com.locales.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table (name = "tb_local")
@EntityListeners(AuditingEntityListener.class)
public class Local {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_local;
	
	@ManyToOne
	@JoinColumn(name = "id_dis")
	private Distrito distrito;
	
	private String dir_local;
    private String tel_local;
    private String email_local;
    private java.time.LocalTime horario_apertura;
    private java.time.LocalTime horario_cierre;
    private String enable = "S";
}