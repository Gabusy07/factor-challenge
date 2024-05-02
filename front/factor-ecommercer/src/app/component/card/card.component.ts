import { Component, Input } from '@angular/core';
import { ROUTES, Router } from '@angular/router';
import { PagesRoutes } from 'src/app/pages/routes';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent {

  @Input() title: String = 'sin titulo';
  @Input() description: String = 'sin descripcion';
  @Input() imgSrc: String = '../assets/products/D_NQ_NP_912227-MLA71782903150_092023-O.webp';

  constructor(private router: Router) {
    this.description =
      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque quos suscipit autem animi est mollitia, quas aspernatur dolore. Harum repellat necessitatibus, exercitationem voluptatum earum dolorem ipsa quam officiis illum fugiat.';
  }

  buyProduct(): void {
      this.router.navigate([PagesRoutes.ROUTES.orderDetails]);
    }
}
