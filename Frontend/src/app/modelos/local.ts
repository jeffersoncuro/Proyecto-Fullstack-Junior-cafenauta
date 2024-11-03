import { Distrito } from "./distrito";

export class Local {
    id_local: number;
    distrito: Distrito;
    dir_local: string;
    tel_local: string;
    email_local: string;
    horario_apertura: string;
    horario_cierre: string; 
    enable: string;

    constructor() {
        this.id_local = 0;
        this.distrito = new Distrito();
        this.dir_local = "";
        this.tel_local = "";
        this.email_local = "";
        this.horario_apertura = "";
        this.horario_cierre = "";
        this.enable = "S";
    }
}