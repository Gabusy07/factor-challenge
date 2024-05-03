import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent {
  @Input() label = 'Button';
  @Input() disabled = false;
  @Input() loading = true;
  @Input() color = 'dark';
  @Input() width = 'auto';
  @Input() height = '38px';
  @Input() img = '';
  @Input() borderRadius= '30px'

}
