import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Categoria } from '../../../modelos/categoria';
import { Producto } from '../../../modelos/producto';
import { ProductoService } from '../../../servicio/producto.service';

@Component({
  selector: 'app-add-producto',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './add-producto.component.html',
  styleUrls: ['./add-producto.component.css']
})
export class AddProductoComponent{

  regProducto = new Producto();

  tipCatego: Categoria[] = [
    { id_categoria: 1, nombre: "Cafés Clásicos", descripcion: "Café negro, espresso, y otras preparaciones tradicionales de café" },
    { id_categoria: 2, nombre: "Cafés Especiales", descripcion: "Bebidas con base de café como cappuccino, latte, y macchiato" },
    { id_categoria: 3, nombre: "Tés e Infusiones", descripcion: "Variedad de tés y tisanas calientes o frías" },
    { id_categoria: 4, nombre: "Bebidas Frías", descripcion: "Frappés, jugos naturales y limonadas" },
    { id_categoria: 5, nombre: "Bebidas con Leche", descripcion: "Lácteos como chocolate caliente y bebidas con leche vegetal" },
    { id_categoria: 6, nombre: "Panadería", descripcion: "Croissants, muffins, y otros panes artesanales" },
    { id_categoria: 7, nombre: "Postres y Repostería", descripcion: "Tartas, brownies, y otros dulces para acompañar" },
    { id_categoria: 8, nombre: "Sandwiches y Bocadillos", descripcion: "Opciones de comida rápida como sandwiches y wraps" },
    { id_categoria: 9, nombre: "Ensaladas", descripcion: "Ensaladas frescas para opciones más ligeras" },
    { id_categoria: 10, nombre: "Snacks y Aperitivos", descripcion: "Galletas, frutos secos, y otros aperitivos para picar" }
  ];

  constructor(private router: Router, private productoService: ProductoService) { 
    this.regProducto.enable = 'S';
  }

  guardarProducto(producto: Producto) {
    this.productoService.Generar_Producto(producto).subscribe(
      res => {
        console.log(res);
        this.router.navigate(['productos']);
      },
      error => console.error('Error al guardar el producto:', error)
    );
  }

  /**boton cancelar */
  cancelar() {
    this.router.navigate(['productos']);
  }

}

