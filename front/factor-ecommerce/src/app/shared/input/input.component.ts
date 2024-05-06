import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  standalone: true,
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.scss'],
  imports: [CommonModule]
})
export class InputComponent {
  @Input() type = 'text';
  @Input() placeholder = '';
  @Input() uppercase = false;
  @Input() hasError = false;
  @Input() errorMessage: string = '';

}
