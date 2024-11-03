import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private baseUrl = environment.apiUrl;
  private url: string = `${this.baseUrl}/productos`;

  constructor(private http:HttpClient) { }

  listar_Productos(): Observable<any>{
    return this.http.get<any>(this.url);
  }
  
  Obtener_Productos_PorId(id_producto: number): Observable<Producto> {
    return this.http.get<Producto>(`${this.url}/${id_producto}`);
  }

  Generar_Producto(producto: Producto): Observable<any> {
    return this.http.post<any>(this.url, producto);
  }

  Actualizar_Producto(id_producto: number, producto: any): Observable<any> {
    return this.http.put<any>(`${this.url}/${id_producto}`, producto);
  }

  Eliminar_Producto(id: number): Observable<any> {
    return this.http.put<any>(`${this.url}/enable/${id}`, {});
  }

}
