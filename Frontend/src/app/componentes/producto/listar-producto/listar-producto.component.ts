import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { Producto } from '../../../modelos/producto';
import { ProductoService } from '../../../servicio/producto.service';

@Component({
  selector: 'app-listar-producto',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-producto.component.html',
  styleUrl: './listar-producto.component.css'
})
export class ListarProductoComponent implements OnInit {

  productos: Producto[] = [];

  constructor(private productoService: ProductoService, private router: Router) { }

  ngOnInit(): void {
    this.ListarProductos();
  }

  ListarProductos(): void {
    this.productoService.listar_Productos().subscribe(response => {
      this.productos = response?.Productos || [];
    });
  }

  nuevo_Producto(): void {
    this.router.navigate(['nuevoProducto']);
  }

  editar_Producto(producto: Producto): void {
    this.router.navigate(['/editarProducto', producto.id_producto]);
  }

  eliminar_Producto(id_producto: number) {
    console.log(id_producto);
    this.productoService.Eliminar_Producto(id_producto).subscribe(
      () => this.ListarProductos()
    ); 
  }

  /*ESTADO ESTILO*/
  getStatusClass(solucionado: string): string {
    return solucionado === 'S'
      ? 'status-pill status-disponible'
      : 'status-pill status-no-disponible';
  }

}
