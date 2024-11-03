package com.feign_client.data.model;

import lombok.Data;

@Data
public class Local {
	private Long id_local;
	private Distrito distrito;
	private String dir_local;
    private String tel_local;
    private String email_local;
    private java.time.LocalTime horario_apertura;
    private java.time.LocalTime horario_cierre;
    private String enable = "S";

}
