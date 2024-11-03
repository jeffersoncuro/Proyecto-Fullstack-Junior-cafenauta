import { Categoria } from "./categoria";

export class Producto {
    id_producto: number;
    nombre: string;
    descripcion: string;
    precio: number;
    id_categoria: Categoria;
    enable: string;

    constructor() {
        this.id_producto = 0;
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0;
        this.id_categoria = new Categoria();
        this.enable = "";
    }
}