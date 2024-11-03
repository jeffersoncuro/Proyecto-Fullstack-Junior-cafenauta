import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule, RouterOutlet } from '@angular/router';
import { Distrito } from '../../../modelos/distrito';
import { DistritoService } from '../../../servicio/distrito.service';

@Component({
  selector: 'app-edit-distrito',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './edit-distrito.component.html',
  styleUrls: ['./edit-distrito.component.css']
})

export class EditDistritoComponent implements OnInit{
  constructor(private router: Router, private distritoService: DistritoService, private route: ActivatedRoute) { }
  regDistrito: Distrito = new Distrito();


  ngOnInit(): void {
    this.editarDistrito();
  }

  editarDistrito(): void {
    const id_dis = this.route.snapshot.paramMap.get('id_dis');
    if (id_dis) {
      this.distritoService.listarDistritosPorId(+id_dis).subscribe(
        (response: any) => {
          console.log('Respuesta completa:', response);
          if (response && response.distritos) {
            this.regDistrito = {
              id_dis: response.distritos.id_dis,
              nom_dis: response.distritos.nom_dis,
            };
            console.log('Distrito cargado:', this.regDistrito);
          } else {
            console.error('La respuesta no tiene la estructura esperada:', response);
          }
        },
        (error) => {
          console.error('Error al cargar el distrito:', error);
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No se pudo cargar el distrito. Por favor, intente nuevamente.',
          });
        }
      );
    }
  }
  
  actualizarDistrito(): void {
    if (!this.regDistrito.nom_dis || this.regDistrito.nom_dis.trim() === '') {
      Swal.fire(
        'Error',
        'El nombre del distrito no puede estar vacío.',
        'error'
      );
      return;
    }
  
    if (this.regDistrito?.id_dis) {
      Swal.fire({
        title: '¿Estás seguro?',
        text: "¿Deseas actualizar este distrito?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, actualizar',
        cancelButtonText: 'Cancelar'
      }).then((result: any) => {
        if (result.isConfirmed) {
          this.distritoService.editarDistrito(this.regDistrito.id_dis, this.regDistrito).subscribe(
            () => {
              Swal.fire(
                '¡Actualizado!',
                'El distrito ha sido actualizado con éxito.',
                'success'
              ).then(() => {
                this.router.navigate(['/distritos']);
              });
            },
            (error) => {
              Swal.fire(
                'Error',
                'Hubo un problema al actualizar el distrito.',
                'error'
              );
            }
          );
        }
      });
    }
  }
  
   /**boton cancelar */
   cancelar() {
    this.router.navigate(['distritos']);
  }
}
