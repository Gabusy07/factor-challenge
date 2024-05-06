import { Component } from '@angular/core';
import { CartService } from '../../services/http/cart.service';
import { Cart } from '../../interfaces/Cart';
import { Order } from '../../interfaces/Order';
import { orderMock } from './OrderMock';
import { cartMock } from './CartMock';
import { ToastModule } from 'primeng/toast';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.scss'],
})
export class OrderDetailsComponent {
  defaultUserId = 1;
  hasError = false;
  //orders: Order[] | undefined;
  orders = orderMock;
  cart: Cart = cartMock;

  //protected cart: Cart | undefined;

  constructor(private readonly cartService: CartService) {
    this.cartService.obtainCart(this.defaultUserId).subscribe({
      next: (data) => {
        this.cart = data;
        //this.orders = data.productOrders
      },
      error: (err) => {
        console.error(err);
        this.hasError = true;
      },
    });
  }


  addQuantity(order: Order):void{

    if(!(order.quantityOrder >= order.product.stock)){
      order.quantityOrder++;
      this.cart.totalPrice += order.product.price;

    }
   
  }
  subQuantity(order: Order):void{
    if(order.quantityOrder > 0){
      order.quantityOrder--;
      this.cart.totalPrice -= order.product.price;
      if(this.cart.totalPrice  < 0){
        this.cart.totalPrice = 0;
        
      }
    }
  }

  buy(){
    
  }
}
