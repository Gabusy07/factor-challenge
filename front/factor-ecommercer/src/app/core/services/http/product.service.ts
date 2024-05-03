import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment as env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private BASE_URL = env.API_BASE_URL;

  constructor(private httpClient: HttpClient) {}
}
