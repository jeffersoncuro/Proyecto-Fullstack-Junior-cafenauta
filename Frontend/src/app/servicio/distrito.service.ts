import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Distrito } from '../modelos/distrito';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DistritoService {
  private baseUrl = environment.apiUrl;
  private distritos: string = `${this.baseUrl}/distritos`

  constructor(private http:HttpClient) { }

  listarDistritos(): Observable<any> {
    return this.http.get<any>(this.distritos);
  }

  listarDistritosPorId(id_dis: number): Observable<Distrito> {
    return this.http.get<Distrito>(`${this.distritos}/${id_dis}`);
  }  

  agregarDistrito(distrito: Distrito): Observable<any> {
    return this.http.post<any>(this.distritos, distrito);
  }

  editarDistrito(id_dis: number, distrito: Distrito): Observable<any> {
    return this.http.put<any>(`${this.distritos}/${id_dis}`, distrito);
  }

  eliminarDistrito(id_dis: number): Observable<any> {
    return this.http.delete<any>(`${this.distritos}/${id_dis}`);
  }
}
