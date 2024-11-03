import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule, RouterOutlet } from '@angular/router';
import { LocalService } from '../../../servicio/local.service';
import { DistritoService } from '../../../servicio/distrito.service';
import { Local } from '../../../modelos/local';
import { Distrito } from '../../../modelos/distrito';

@Component({
  selector: 'app-edit-local',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './edit-local.component.html',
  styleUrl: './edit-local.component.css'
})
export class EditLocalComponent implements OnInit {

  constructor(
    private router: Router,
    private localService: LocalService,
    private distritoService: DistritoService,
    private route: ActivatedRoute) { }

  regLocal: Local = new Local();
  distritos: Distrito[] = [];

  ngOnInit(): void {
    this.cargarDistritos();
    this.editarLocal();
  }

  cargarDistritos(): void {
    this.distritoService.listarDistritos().subscribe(response => {
      this.distritos = response?.distritos || [];
    });
  }

  editarLocal(): void {
    const id_local = this.route.snapshot.paramMap.get('id_local');

    if (id_local) {
      this.localService.listarLocalesPorId(+id_local).subscribe(
        (response: any) => {
          if (response && response.locales) {
            this.regLocal = {
              id_local: response.locales.id_local,
              distrito: this.distritos.find(d => d.id_dis === response.locales.distrito.id_dis) || response.locales.distrito,
              dir_local: response.locales.dir_local,
              tel_local: response.locales.tel_local,
              email_local: response.locales.email_local,
              horario_apertura: response.locales.horario_apertura,
              horario_cierre: response.locales.horario_cierre,
              enable: response.locales.enable
            };
          }
        },
        error => {
          console.error('Error al cargar el local:', error);
        }
      );
    }
  }



  actualizarLocal(): void {
    if (this.regLocal.distrito && this.regLocal.distrito.id_dis) {
      this.regLocal.distrito = this.distritos.find(d => d.id_dis === this.regLocal.distrito.id_dis) || this.regLocal.distrito;
    }

    if (this.regLocal?.id_local) {
      this.localService.editarLocal(this.regLocal.id_local, this.regLocal).subscribe(() => {
        this.router.navigate(['/locales']);
      });
    }
  }

  /**boton cancelar */
  cancelar() {
    this.router.navigate(['locales']);
  }

}
