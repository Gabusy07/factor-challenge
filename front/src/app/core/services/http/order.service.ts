import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderRequest } from '../../interfaces/OrderRequest';
import { environment as env } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class OrderHttpService {
  

  private readonly URL =`${env.API_BASE_URL}/api/v1/orders/`;

  constructor(private httpClient: HttpClient) {}

  createOrder(order: OrderRequest): Observable<void>{
    const URL = `${this.URL}create`;
    return this.httpClient.post<void>(URL, order);  
  }

}
