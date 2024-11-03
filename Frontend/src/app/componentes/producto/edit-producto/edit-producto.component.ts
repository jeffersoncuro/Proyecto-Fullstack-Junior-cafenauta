import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule, RouterOutlet } from '@angular/router';
import { Producto } from '../../../modelos/producto';
import { Categoria } from '../../../modelos/categoria';
import { ProductoService } from '../../../servicio/producto.service';

@Component({
  selector: 'app-edit-producto',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './edit-producto.component.html',
  styleUrls: ['./edit-producto.component.css']
})
export class EditProductoComponent implements OnInit {
  regProducto: Producto = new Producto();
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

  constructor(
    private router: Router,
    private productoService: ProductoService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.cargarProducto();
  }

  cargarProducto(): void {
    const id_producto = this.route.snapshot.paramMap.get('id_producto');
    if (id_producto) {
      this.productoService.Obtener_Productos_PorId(+id_producto).subscribe(
        (response: any) => {
          if (response && response.Productos) {
            this.regProducto = response.Productos;
            this.actualizarCategoria();
          }
        },
        error => console.error('Error al cargar el producto:', error)
      );
    }
  }

  actualizarCategoria(): void {
    const categoriaEncontrada = this.tipCatego.find(cat => cat.id_categoria === this.regProducto.id_categoria.id_categoria);
    if (categoriaEncontrada) {
      this.regProducto.id_categoria = categoriaEncontrada;
    }
  }

  onSubmit(): void {
    this.productoService.Actualizar_Producto(this.regProducto.id_producto, this.regProducto).subscribe(
      () => this.router.navigate(['/productos']),
      error => console.error('Error al actualizar:', error)
    );
  }

  /**boton cancelar */
  cancelar() {
    this.router.navigate(['productos']);
  }
}
