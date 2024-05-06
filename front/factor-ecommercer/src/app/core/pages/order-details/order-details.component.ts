import { Component } from '@angular/core';
import { CartService } from '../../services/http/cart.service';
import { Cart } from '../../interfaces/Cart';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.scss']
})
export class OrderDetailsComponent {

  defaultUserId = 1;
  hasError = false;


  protected cart: Cart | undefined;


  constructor(
    private readonly cartService: CartService
  ){
    cartService.obtainCart(this.defaultUserId).subscribe(
      {
        next: data => this.cart = data,
        error: err => {
          console.error(err);
          this.hasError = true;
        }
      }
    )
  }


  orders: number[] = [1, 2, 3, 4, 5];


}
