import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, tap, throwError } from 'rxjs';
import { LocalStorageService } from 'src/app/common/local-storage.service';
import { TokenResponse } from '../interfaces/Token';
import { environment as env } from 'src/environments/environment.dev';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private URL =`${env.API_BASE_URL}/api/v1/auth/`;

  constructor( 
    private httpClient: HttpClient,
    private localStorageService: LocalStorageService) {
   }

   login(data: any): Observable<any> {
    const URL = `${this.URL}login`;
    const loginDto = this.getLoginDto(data);
    this.localStorageService.set('username', data.username);
    const options = {
      responseType: 'text' as 'json'
    };
    
    return this.httpClient.post<TokenResponse>(URL, loginDto, options).pipe(
      tap((result: TokenResponse) => {
        this.localStorageService.set('sessionToken', result.token);
        this.localStorageService.set('id', result.id);
        if (!result) {
          throw new Error('Credentials are invalid');
        }
      }),
      catchError((error: any) => {
        return throwError(error);
      })
    );
  }

  private getLoginDto(data: any) {
    return {
      username: data.username,
      password: data.password,
    };
  }

}