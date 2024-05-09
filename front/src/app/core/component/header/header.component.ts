import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LocalStorageService } from 'src/app/common/local-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {

  private username: string | null;

  constructor(
    private router: Router,
    private readonly localStorageService: LocalStorageService,
  ) {
    this.username = this.localStorageService.get('username') ?? null;
  }
  navigateToLoginPage() {
    if(!this.username){
      this.router.navigate(['auth/login']);
    }
  }

  get Username(): string | null {
    return this.username;
  }
  closeSesion() {
    this.username = null;
    this.localStorageService.clear();
  }

  navigateToOrder() {
    this.router.navigate(['/order-details']);
  }

  //TODO  implementar buscador
  onClick() {
    throw new Error('Method not implemented.');
    }
}
