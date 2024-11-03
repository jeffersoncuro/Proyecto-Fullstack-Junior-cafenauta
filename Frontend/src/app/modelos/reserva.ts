import { Local } from "./local";

export class Reserva {
  idRes: number;
  local: Local;
  nomRes: string;
  apeRes: string;
  emailRes: string;
  telRes: string;
  fechaReserva: Date;
  horaReserva: { hours: number, minutes: number };
  comensales: number;
  enable: string;

  constructor() {
    this.idRes = 0;
    this.local = new Local();
    this.nomRes = "";
    this.apeRes = "";
    this.emailRes = "";
    this.telRes = "";
    this.fechaReserva = new Date();
    this.horaReserva = { hours: 0, minutes: 0 }; 
    this.comensales = 0;
    this.enable = "S";
  }
}