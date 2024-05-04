import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthModule } from './auth/auth.module';
import { MainLayoutComponent } from './core/main-layout/main-layout.component';

const routes: Routes = [

  {
    path: '',
    loadChildren: () => import('./core/main.module').then((m) => m.MainModule),
  },
  
  {
    path: "auth",
    loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), AuthModule],
  exports: [RouterModule]
})

export class AppRoutingModule {
  
 }
