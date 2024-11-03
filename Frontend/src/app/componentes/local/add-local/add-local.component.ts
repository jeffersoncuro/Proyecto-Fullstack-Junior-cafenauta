import { Component } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LocalService } from '../../../servicio/local.service';
import { Local } from '../../../modelos/local';
import { DistritoService } from '../../../servicio/distrito.service';
import { Distrito } from '../../../modelos/distrito';

@Component({
  selector: 'app-add-local',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './add-local.component.html',
  styleUrl: './add-local.component.css'
})
export class AddLocalComponent {

  constructor(
    private router:Router, 
    private localService:LocalService,
    private distritoService:DistritoService) {}

  regLocal = new Local();
  distritos: Distrito[] = [];

  ngOnInit(): void {
    this.cargarDistritos();
  }

  cargarDistritos(): void {
    this.distritoService.listarDistritos().subscribe(response => {
      this.distritos = response?.distritos || [];
    });
  }
  
  guardarLocal(local: Local) {
    this.regLocal.distrito = { id_dis: this.regLocal.distrito.id_dis } as Distrito;

    this.localService.agregarLocal(local).subscribe(
      data => {
        this.router.navigate(['locales']);
      }
    )
  }
  /**boton cancelar */
  cancelar() {
    this.router.navigate(['locales']);
  }

}
