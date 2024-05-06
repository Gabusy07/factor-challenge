import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../../interfaces/Cart';
import { environment as env } from 'src/environments/environment.dev';

@Injectable({
  providedIn: 'root'
})
export class CartService {


  private URL =`${env.API_BASE_URL}/api/v1/carts/`;

  constructor(private httpClient: HttpClient) {}

  obtainCart(UserId: number): Observable<Cart>{
    const URL = `${this.URL}${UserId}`;
    return this.httpClient.get<any>(URL);  
  }

  finalizePurchase(cart: Cart): Observable<void>{
    const URL = `${this.URL}executePurchase`;
    return this.httpClient.post<void>(URL, cart);  
  }

  update(cart: Cart, userId: number) {
    const URL = `${this.URL}update/${userId}`;
    return this.httpClient.patch<Cart>(URL, cart); 
    
  }
}
