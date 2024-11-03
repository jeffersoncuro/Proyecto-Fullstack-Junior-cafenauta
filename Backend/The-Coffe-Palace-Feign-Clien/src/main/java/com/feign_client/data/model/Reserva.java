package com.feign_client.data.model;

import java.time.LocalDate;
import java.time.LocalTime;



import lombok.Data;

@Data
public class Reserva {
	
		private Long idRes;
	    private Local local;
	    private String nomRes;
	    private String apeRes;
	    private String emailRes;
	    private String telRes;
	    private LocalDate fechaReserva;
	    private LocalTime horaReserva;
	    private int comensales;
	    private String enable = "S";

}
