import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  private baseUrl = environment.url;
  login : string = this.baseUrl + "/login";
  private userSubject = new BehaviorSubject<any>(null);

  ingresar(request: any): Observable<any> {
    return this.http.post(`${this.login}`, request, { observe: 'response' })
      .pipe(map((response: HttpResponse<any>) => {
        const body = response.body;
        const headers = response.headers;

        const bearerToken = headers.get('Authorization');
        if (bearerToken) {
          const token = bearerToken.replace('Bearer ', '');
          localStorage.setItem('token', token);
          this.userSubject.next(this.decodeToken(token));
        }
        return body;
      }));
  }

  private decodeToken(token: string) {
    const payload = token.split('.')[1];
    const decodedPayload = atob(payload);
    return JSON.parse(decodedPayload);
  }

  private isTokenExpired(token: string): boolean {
    const decodedToken = this.decodeToken(token);
    const currentTime = Math.floor(Date.now() / 1000);
    return decodedToken.exp < currentTime;
  }

  private isLocalStorageAvailable(): boolean {
    try {
      const testKey = '__test__';
      localStorage.setItem(testKey, 'test');
      localStorage.removeItem(testKey);
      return true;
    } catch (error) {
      return false;
    }
  }
  
  token() {
    if (this.isLocalStorageAvailable()) {
      const token = localStorage.getItem('token');
      if (token && !this.isTokenExpired(token)) {
        return token;
      } else {
        localStorage.removeItem('token');
        return null;
      }
    }
    return null;
  }
  
  logout() {
    localStorage.removeItem('token');
    this.userSubject.next(null);
  }
}