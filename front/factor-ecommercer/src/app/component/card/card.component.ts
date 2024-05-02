import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent {

  @Input() title:String = "sin titulo";
  @Input() imgSrc:String = "../assets/products/D_NQ_NP_912227-MLA71782903150_092023-O.webp";
}
