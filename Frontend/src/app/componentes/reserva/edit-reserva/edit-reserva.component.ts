import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet, RouterModule, ActivatedRoute, Router } from '@angular/router';
import { Reserva } from '../../../modelos/reserva';
import { ReservaService } from '../../../servicio/reserva.service';
import { FormsModule } from '@angular/forms';
import { Local } from '../../../modelos/local';

@Component({
  selector: 'app-edit-reserva',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './edit-reserva.component.html',
  styleUrls: ['./edit-reserva.component.css']
})
export class EditReservaComponent implements OnInit {
  regReserva: Reserva = new Reserva();
  
  constructor(private router: Router, private route: ActivatedRoute, private reservaService: ReservaService) { }


  ngOnInit(): void {
    this.editarReserva();
  }

  editarReserva(): void {
    const idRes = this.route.snapshot.paramMap.get('idRes');
    if (idRes) {
      this.reservaService.obtenerReserva(+idRes).subscribe(
        (response: any) => {
          console.log('Reserva completa:', response);
          if (response && response.reservas) {
            this.regReserva = {
              idRes: response.reservas.idRes,
              local: response.reservas.local || new Local(),
              nomRes: response.reservas.nomRes,
              apeRes: response.reservas.apeRes,
              emailRes: response.reservas.emailRes,
              telRes: response.reservas.telRes,
              fechaReserva: response.reservas.fechaReserva.split('T')[0],
              horaReserva: response.reservas.horaReserva,
              comensales: response.reservas.comensales,
              enable: response.reservas.enable
            };
          }
        },
        (error) => {
          console.error('Error al cargar la reserva', error);
        }
      );
    }
  }
  

  actualizarReserva(): void {
    const id_res = this.regReserva.idRes;
    if (id_res) {
      this.reservaService.editarReserva(id_res, this.regReserva).subscribe(
        (response) => {
          console.log('Reserva actualizada:', response);
          this.router.navigate(['/reservas']);
        },
        (error) => {
          console.error('Error al actualizar la reserva', error);
        }
      );
    } else {
      console.error('ID de reserva no encontrado.');
    }
  }

  /**boton cancelar */
  cancelar() {
    this.router.navigate(['reservas']);
  }

}
