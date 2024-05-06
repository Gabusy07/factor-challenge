import { Component } from '@angular/core';
import { CartService } from '../../services/http/cart.service';
import { Cart } from '../../interfaces/Cart';
import { Order } from '../../interfaces/Order';
import { orderMock } from './OrderMock';
import { cartMock } from './CartMock';
import { ToastModule } from 'primeng/toast';
import { Router } from '@angular/router';
import { LocalStorageService } from 'src/app/common/local-storage.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.scss'],
})
export class OrderDetailsComponent {
  defaultUserId = 1;
  hasError = false;
  orders: Order[] | undefined;
  //orders = orderMock;
  cart: Cart | undefined;
  loading: Boolean = false;
  purchaseCompleted: Boolean = false;

  //protected cart: Cart | undefined;

  constructor(
    private readonly cartService: CartService,
    private readonly router: Router,
    private readonly localStorageService: LocalStorageService,
  ) {

    const cartString =  this.localStorageService.get('currentCart'); 
if (cartString) {
  try {
    const cartObject = JSON.parse(cartString); 
    const typedCart: Cart = cartObject as Cart;
    this.cart = typedCart;
    this.orders = this.cart.productOrders
  } catch (error) {
    console.error('Error parser', error);
  }
} else {
  console.error('object currentCart not found.');
}

    
}


  addQuantity(order: Order):void{

    if(!(order.quantityOrder >= order.product.stock)){
      order.quantityOrder++;
      this.cart!.totalPrice += order.product.price;

    }
   
  }
  subQuantity(order: Order):void{
    if(order.quantityOrder > 0){
      order.quantityOrder--;
      this.cart!.totalPrice -= order.product.price;
      if(this.cart!.totalPrice  < 0){
        this.cart!.totalPrice = 0;
        
      }
    }
  }

  finalizePurchase(){
    this.loading = true;
    this.cartService.finalizePurchase(this.cart!).subscribe(
      {
        next: () => {
          this.loading = false;
          this.purchaseCompleted = true;
         
        },
        error: (err) =>  {
          this.hasError = true;
          console.error(err)
        },
        complete: ()=> this.router.navigate(['/'])

        
      }
    )
  
  }
}
