import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Reserva } from '../modelos/reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private baseUrl = environment.apiUrl;
  private url: string = `${this.baseUrl}/reservas`

  constructor(private http:HttpClient) { }

  listarReserva(): Observable<any>{
    return this.http.get<any>(this.url);
  }

  obtenerReserva(id_res:number):Observable<Reserva>{
    return this.http.get<Reserva>(`${this.url}/${id_res}`);
  }

  agregarReserva(reserva:Reserva):Observable<any>{
    return this.http.post<any>(this.url, reserva);
  }

  editarReserva(id_res:number, reserva:Reserva):Observable<any>{
    return this.http.put<any>(`${this.url}/${id_res}`,reserva);
  }

  eliminarReserva(id_res: number):Observable<any>{
    return this.http.delete<any>(`${this.url}/${id_res}`);
  }

  listarReservaEnable(): Observable<any> {
    return this.http.get<any>(`${this.url}/enable`);
  }

  eliminarReservaEnable(id_res: number): Observable<any> {
    return this.http.put<any>(`${this.url}/eliminar/${id_res}`, {});
  }

}
