import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { Local } from '../../../modelos/local';
import { LocalService } from '../../../servicio/local.service';

@Component({
  selector: 'app-listar-local',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-local.component.html',
  styleUrl: './listar-local.component.css'
})
export class ListarLocalComponent implements OnInit{
  locales: Local[] = [];

  constructor(private localService:LocalService, private router: Router) {}

  ngOnInit(): void {
      this.cargarLocales();
  }

  cargarLocales(): void {
    this.localService.listarLocales().subscribe(response => {
      this.locales = response?.locales || [];
    })
  }

  nuevoLocal(): void {
    this.router.navigate(['nuevoLocal']);
  }

  editarLocal(local: Local): void {
    this.router.navigate(['/editarLocal', local.id_local]);
  }

  listarLocalesEnable(): void {
    this.router.navigate(['localesEnable']);
  }
  
  eliminarLocalEnable(local: Local): void {
    local.enable = "N";

    this.localService.eliminarLocalEnable(local).subscribe(
      updatedLocal => {
        const index = this.locales!.findIndex(p => p.id_local === updatedLocal.id_local);
        if (index !== -1) {
          this.locales![index] = updatedLocal;
        }
        console.log('Local actualizado:', updatedLocal);
      },
      error => {
        console.error('Error al actualizar el Local:', error);
      }
    );
  }

  /*ESTADO ESTILO*/
  getStatusClass(solucionado: string): string {
    return solucionado === 'S'
      ? 'status-pill status-disponible'
      : 'status-pill status-no-disponible';
  }
}
