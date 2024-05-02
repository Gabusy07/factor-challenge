import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonComponent } from './shared/button/button.component';
import { InputComponent } from './shared/input/input.component';
import { TableComponent } from './shared/table/table.component';
import { HomeComponent } from './pages/home/home.component';
import { ErrorPageComponent } from './pages/error-page/error-page.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { HeaderComponent } from './component/header/header.component';
import { CardComponent } from './component/card/card.component';
import { OrderDetailsComponent } from './pages/order-details/order-details.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ButtonComponent,
    InputComponent,
    TableComponent,
    HomeComponent,
    ErrorPageComponent,
    MainLayoutComponent,
    HeaderComponent,
    CardComponent,
    OrderDetailsComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
