import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  standalone: true,
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss'],
  imports: [CommonModule]
})
export class ButtonComponent {
  @Input() label = 'Button';
  @Input() disabled: Boolean = false;
  @Input() loading: Boolean = true;
  @Input() color = 'dark';
  @Input() width = 'auto';
  @Input() height = '38px';
  @Input() img = '';
  @Input() borderRadius= '30px'

}
