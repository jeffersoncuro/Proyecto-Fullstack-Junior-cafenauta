import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { ReservaService } from '../../../servicio/reserva.service';
import { LocalService } from '../../../servicio/local.service';
import { Local } from '../../../modelos/local';
import { Reserva } from '../../../modelos/reserva';

@Component({
  selector: 'app-add-reserva',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './add-reserva.component.html',
  styleUrls: ['./add-reserva.component.css']
})
export class AddReservaComponent implements OnInit {
  constructor(private router: Router, private reservaService: ReservaService, private localService: LocalService) {
  }

  regReserva = new Reserva();
  locales: Local[] = [];

  ngOnInit(): void {
    this.obtenerLocales();
  }


  obtenerLocales(): void {
    this.localService.listarLocales().subscribe(response => {
      this.locales = response?.locales || [];
    });
  }

  guardaReserva(reserva: Reserva) {
    this.reservaService.agregarReserva(reserva).subscribe(
      () => {
        this.router.navigate(['reservas']);
      },
      error => {
        console.error('Error al guardar la reserva', error);
      }
    );
  }

  /**boton cancelar */
  cancelar() {
    this.router.navigate(['reservas']);
  }

}
