import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './pages/login/login.component';
import { AuthLayoutComponent } from './layout/auth-layout/auth-layout.component';
import { AuthRoutingModule } from './auth-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ButtonComponent } from "../shared/button/button.component";



@NgModule({
    declarations: [
        LoginComponent,
        AuthLayoutComponent,
    ],
    imports: [
        CommonModule,
        AuthRoutingModule,
        ReactiveFormsModule,
        ButtonComponent
    ]
})
export class AuthModule { }
