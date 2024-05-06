import { Component } from '@angular/core';
import { environment as env } from '../environments/environment.dev';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'factor-ecommercer';

  constructor(){
    console.info("app-component init");
    console.info(env.API_BASE_URL);
    console.info(env.version);
    console.info(env.ENV);
  }
}
