export class Categoria{
    id_categoria:number;
    nombre:string;
    descripcion:string;

    constructor(id: number=0, nombre: string = "", descripcion: string = ""){
        this.id_categoria=0;
        this.nombre="";
        this.descripcion="";
    }
}