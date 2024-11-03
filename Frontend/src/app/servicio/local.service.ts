import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Local } from '../modelos/local';

@Injectable({
  providedIn: 'root'
})
export class LocalService {
  private baseUrl = environment.apiUrl;
  private url: string = `${this.baseUrl}/locales`

  constructor(private http:HttpClient) { }

  listarLocales(): Observable<any>{
    return this.http.get<any>(this.url);
  }

  listarLocalesEnable(): Observable<any> {
    return this.http.get<any>(`${this.url}/enable`);
  }

  listarLocalesPorId(id_local: number): Observable<Local> {
    return this.http.get<Local>(`${this.url}/${id_local}`);
  }  

  agregarLocal(local: Local): Observable<any> {
    return this.http.post<any>(this.url, local);
  }

  editarLocal(id_local: number, local: Local): Observable<any> {
    return this.http.put<any>(`${this.url}/${id_local}`, local);
  }

  eliminarLocalEnable(local: Local): Observable<any> {
    return this.http.put<Local>(`${this.url}/enable/${local.id_local}`, local);
  }

}
