import { Component, OnInit } from '@angular/core';
import { Product} from '../../interfaces/Product';
import { ProductHttpService } from '../../services/http/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  p: Product = {
    id: 1,
    name: "dsdhb",
    description: "gdnj",
    stock: 2,
    code: "gm",
    price: 5,
    image: "fnjdt",

  }
  
  products: Product[] = [];

  constructor(private readonly productHttpService: ProductHttpService ){
    // this.products.push(this.p)
    // this.products.push(this.p)
    // this.products.push(this.p)
  }

  ngOnInit(): void {
    this.productHttpService.getAllProducts().subscribe(
      {
        next: (data) => this.products = data,
        error: err => console.error(err),
        complete: ()=> {

        }
      }
    )
    
  }



  

}
