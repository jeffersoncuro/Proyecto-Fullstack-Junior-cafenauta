package com.locales.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "tb_distrito")
@EntityListeners(AuditingEntityListener.class)
public class Distrito {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dis;
	private String nom_dis;

	@OneToMany(mappedBy = "distrito", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Local> locales;
}
