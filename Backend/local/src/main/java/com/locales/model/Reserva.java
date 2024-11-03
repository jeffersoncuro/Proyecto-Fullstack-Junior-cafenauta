package com.locales.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tb_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_res")
    private Long idRes;

    @ManyToOne
    @JoinColumn(name = "id_local", nullable = false)
    private Local local;

    @Column(name = "nom_res", length = 25, nullable = false)
    private String nomRes;

    @Column(name = "ape_res", length = 25, nullable = false)
    private String apeRes;

    @Column(name = "email_res", length = 50)
    @Email
    private String emailRes;

    @Column(name = "tel_res", length = 9)
    private String telRes;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "hora_reserva", nullable = false)
    private LocalTime horaReserva;

    @Column(name = "comensales", nullable = false)
    private int comensales;

    @Column(name = "enable", nullable = false)
    private String enable = "S";
}
