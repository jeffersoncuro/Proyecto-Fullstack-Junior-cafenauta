import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { Local } from '../../../modelos/local';
import { LocalService } from '../../../servicio/local.service';

@Component({
  selector: 'app-listar-local-enable',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-local-enable.component.html',
  styleUrl: './listar-local-enable.component.css'
})
export class ListarLocalEnableComponent {
  locales: Local[] = [];

  constructor(private localService:LocalService, private router: Router) {}

  ngOnInit(): void {
      this.cargarLocales();
  }

  cargarLocales(): void {
    this.localService.listarLocalesEnable().subscribe(response => {
      this.locales = response?.locales || [];
    })
  }
}
