import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { OrderDetailsComponent } from './pages/order-details/order-details.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';

const routes: Routes = [

  {
    path: '',
    component: MainLayoutComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'order-details', component: OrderDetailsComponent },
    ]
  }
  
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}
