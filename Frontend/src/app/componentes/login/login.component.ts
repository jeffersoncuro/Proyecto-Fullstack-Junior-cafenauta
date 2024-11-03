import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { LoginService } from '../../servicio/login.service';
import { CommonModule } from '@angular/common'; 


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent{
  showPassword = false;
  usuario: any[] = [];
  formLogin: FormGroup;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private fb: FormBuilder
) {
    this.formLogin = this.fb.group({
        email: new FormControl(null, [Validators.required, Validators.email]),
        password: new FormControl(null, [Validators.required, Validators.minLength(1)])
    });
}


  login() {
    if(this.formLogin.valid) {
      console.log("Login", this.formLogin.value);
      this.loginService.ingresar(this.formLogin.value)
      .subscribe({
        next: (res) => {
          console.log("Response: ", res);
          this.router.navigate(['/locales']);
        },
        error: (err: HttpErrorResponse) => {
          this.alertaError();
        }
      });
    }
  }

  alertaError() {
    Swal.fire({
      position: "top-end",
      icon: "error",
      title: "Datos incorrectos",
      showConfirmButton: false,
      timer: 1500
    });
    this.formLogin.reset();
  }

  cambiarVisibilidadDeClave() {
    this.showPassword = !this.showPassword;
  }
}
