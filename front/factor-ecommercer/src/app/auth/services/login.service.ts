import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, tap, throwError } from 'rxjs';
import { LocalStorageService } from 'src/app/common/local-storage.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private URL = "http://localhost:8080/api/v1/auth/";

  constructor( 
    private httpClient: HttpClient,
    private localStorageService: LocalStorageService) {
   }

   login(data: any): Observable<any> {
    console.log(data)
    const URL = `${this.URL}login`;
    const loginDto = this.getLoginDto(data);
    this.localStorageService.set('username', data.username);
    const options = {
      responseType: 'text' as 'json'
    };
    
    return this.httpClient.post<any>(URL, loginDto, options).pipe(
      tap((result: string) => {
        this.localStorageService.set('sessionToken', result);
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
