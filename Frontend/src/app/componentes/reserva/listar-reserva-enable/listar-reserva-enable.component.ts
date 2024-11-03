import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet, RouterModule, Router } from '@angular/router';
import { ReservaService } from '../../../servicio/reserva.service';
import { Reserva } from '../../../modelos/reserva';

@Component({
  selector: 'app-listar-reserva-enable',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-reserva-enable.component.html',
  styleUrls: ['./listar-reserva-enable.component.css']
})
export class ListarReservaEnableComponent implements OnInit{
  reservas: Reserva[] = [];
  mensajeError: string = '';

  constructor(private reservaService: ReservaService, private router: Router) { }

  ngOnInit(): void {
    this.cargarReservasEnable();
  }

  cargarReservasEnable(): void {
    this.reservaService.listarReservaEnable().subscribe(
      data => {
        this.reservas = data.reservas; // Asegúrate de que `reservas` está en el cuerpo de la respuesta
      },
      error => {
        this.mensajeError = error.message || 'Error al cargar las reservas habilitadas';
      }
    );
  }

}
