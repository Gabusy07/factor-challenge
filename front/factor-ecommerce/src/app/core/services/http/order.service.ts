import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { Product } from '../../interfaces/Product';

@Injectable({
  providedIn: 'root'
})
export class OrderHttpService {

  private URL = "http://localhost:8080/api/v1/products/";

  constructor(private httpClient: HttpClient) {}

  getAllProducts(): Observable<Product[]>{
    const URL = `${this.URL}all`;
    return this.httpClient.get<any>(URL);  
  }
}
