package com.feign_client.data.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 20)
    private String nombre;

    private String apellido_Paterno;
    private String apellido_Materno;
    private String dni;
    private String telefono;
    private String direccion;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 255)
    private String password;
}