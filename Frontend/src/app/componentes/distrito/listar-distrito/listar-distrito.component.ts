import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { Distrito } from '../../../modelos/distrito';
import { DistritoService } from '../../../servicio/distrito.service';

@Component({
  selector: 'app-listar-distrito',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-distrito.component.html',
  styleUrls: ['./listar-distrito.component.css']
})
export class ListarDistritoComponent implements OnInit {
  distritos: Distrito[] = [];

  constructor(private distritoService: DistritoService, private router: Router) {}

  ngOnInit(): void {
    this.cargarDistritos();
  }

  cargarDistritos(): void {
    this.distritoService.listarDistritos().subscribe(response => {
      this.distritos = response?.distritos || [];
    });
  }

  nuevoDistrito(): void {
    this.router.navigate(['nuevoDistrito']);
  }

  editarDistrito(distrito: Distrito): void {
    this.router.navigate(['/editarDistrito', distrito.id_dis]);
  }
}