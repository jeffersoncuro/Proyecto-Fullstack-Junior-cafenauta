import { Component } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Distrito } from '../../../modelos/distrito';
import { DistritoService } from '../../../servicio/distrito.service';

@Component({
  selector: 'app-add-distrito',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './add-distrito.component.html',
  styleUrls: ['./add-distrito.component.css']
})
export class AddDistritoComponent {
  constructor(private router:Router, private distritoService:DistritoService){}
  regDistrito = new Distrito();

  guardarDistrito(distrito: Distrito) {
    if (!distrito.nom_dis || distrito.nom_dis.trim() === '') {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Debe colocar el nombre del distrito',
      });
      return;
    }

    this.distritoService.agregarDistrito(distrito).subscribe(
      data => {
        Swal.fire({
          icon: 'success',
          title: 'Éxito',
          text: 'El distrito ha sido guardado correctamente',
        }).then((result: any) => {
          if (result.isConfirmed) {
            this.router.navigate(['distritos']);
          }
        });
      },
      error => {
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Hubo un problema al guardar el distrito',
        });
      }
    );
  }

  /**boton cancelar */
  cancelar() {
    this.router.navigate(['distritos']);
  }
}
