import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment as env } from 'src/environments/environment.dev';
import { Product } from '../../interfaces/Product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductHttpService {

  private readonly URL =`${env.API_BASE_URL}/api/v1/products/`;

  constructor(private httpClient: HttpClient) {}

  getAllProducts(): Observable<Product[]>{
    const URL = `${this.URL}all`;
    return this.httpClient.get<any>(URL);  
  }
}
