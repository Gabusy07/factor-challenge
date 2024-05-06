import { Component, EventEmitter, Input, Output } from '@angular/core';
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
  @Input() disabled: Boolean = true;
  @Output() buttonClicked: EventEmitter<boolean> = new EventEmitter<boolean>();

  defaultImg = '../assets/products/Image_not_available.png';


  constructor() {}

  buttomClicked() {
    this.buttonClicked.emit(true);
      
    }
}
