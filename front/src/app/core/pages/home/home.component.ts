import { Component, OnInit } from '@angular/core';
import { Product } from '../../interfaces/Product';
import { ProductHttpService } from '../../services/http/product.service';
import { Router } from '@angular/router';
import { OrderHttpService } from '../../services/http/order.service';
import { OrderRequest } from '../../interfaces/OrderRequest';
import { CartService } from '../../services/http/cart.service';
import { Cart } from '../../interfaces/Cart';
import { LocalStorageService } from 'src/app/common/local-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  products: Product[] = [];
  loading: Boolean = false;
  hasError: boolean = false;
  cart: Cart | undefined;
  userId;

  constructor(
    private readonly productHttpService: ProductHttpService,
    private router: Router,
    private readonly orderHttpService: OrderHttpService,
    private readonly cartService: CartService,
    private readonly localStorageService: LocalStorageService,
  ) {
    this.userId = Number(this.localStorageService.get('id')) ;
    let username = this.localStorageService.get('username');
    if (username) {
      this.cartService.obtainCart(this.userId).subscribe({
        next: (data) => {
          this.cart = data;
          this.localStorageService.set('currentCart', this.cart);
        },
        error: (err) => {
          console.error(err);
          this.hasError = true;
        },
      });
    }
  }

  ngOnInit(): void {
    this.productHttpService.getAllProducts().subscribe({
      next: (data) => (this.products = data),
      error: (err) => console.error(err),
      complete: () => {},
    });
  }

  addProductToCart(product: Product) {
    this.loading = true;
    let createdOrder = this.createNewOrder(product);
    this.orderHttpService.createOrder(createdOrder).subscribe({
      next: () => {
        this.cartService.obtainCart(1).subscribe({
          next: (data) => {
            this.localStorageService.set('currentCart', data);
            this.loading = false;
            this.router.navigate(['order-details']);
          },
          error: (err) => console.error(err),
        });
      },
      error: (err) => {
        console.error(err);
        this.hasError = true;
      },
    });
  }

  createNewOrder(product: Product): OrderRequest {
    return {
      quantityOrder: 1,
      productId: product.id,
      cartId: this.cart?.id || 0,
    };
  }
}
