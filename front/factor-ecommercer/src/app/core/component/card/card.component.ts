import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent {

  @Input() title: String = 'sin titulo';
  @Input() description: String | null = 'sin descripcion';
  @Input() imgSrc: String | undefined;
  @Input() price: Number | undefined;

  defaultImg = '../assets/products/Image_not_available.png';


  constructor(private router: Router) {}

  buyProduct(): void {
      this.router.navigate(['order-details'] );
    }
}
