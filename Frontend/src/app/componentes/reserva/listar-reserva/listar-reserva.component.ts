import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../../modelos/reserva';
import { ReservaService } from '../../../servicio/reserva.service';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar-reserva',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-reserva.component.html',
  styleUrls: ['./listar-reserva.component.css']
})
export class ListarReservaComponent implements OnInit {
  reservas: Reserva[] = [];
  mensajeError: string = '';

  constructor(private reservaService: ReservaService, private router: Router) { }

  ngOnInit(): void {
    this.listarReservas();
  }

  listarReservas(): void {
    this.reservaService.listarReserva().subscribe(response => {
      this.reservas = response?.reservas || [];
    }, error => {
      this.mensajeError = 'Error al obtener las reservas. Intente más tarde.';
    }
    );
  }

  listarReservasEnable(): void {
    this.router.navigate(['reservasEnable']);
  }

  nuevaReserva(): void {
    this.router.navigate(['nuevaReserva'])
  }

  editarReserva(reserva: Reserva): void {
    this.router.navigate(['/editarReserva', reserva.idRes]);
  }

  eliminarReservaEnable(idRes: number): void {
    this.reservaService.eliminarReservaEnable(idRes).subscribe(
      response => {
        alert('Reserva deshabilitada correctamente.');
        // Refrescar la lista de reservas habilitadas
        this.listarReservas();
      },
      error => {
        this.mensajeError = 'Error al deshabilitar la reserva. Intente más tarde.';
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
