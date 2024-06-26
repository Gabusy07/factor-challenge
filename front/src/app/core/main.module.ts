import { NgModule } from '@angular/core';
import { HomeComponent } from './pages/home/home.component';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { HeaderComponent } from './component/header/header.component';
import { CardComponent } from './component/card/card.component';
import { OrderDetailsComponent } from './pages/order-details/order-details.component';
import { ButtonComponent } from '../shared/button/button.component';
import { InputComponent } from '../shared/input/input.component';
import { MainRoutingModule } from './main-routing.module';
import { CommonModule } from '@angular/common';
import { TruncatePipe } from '../pipes/truncate.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ConfirmPurchasePageComponent } from './pages/confirm-purchase-page/confirm-purchase-page.component';



@NgModule({
  declarations: [
    HomeComponent,
    MainLayoutComponent,
    HeaderComponent,
    CardComponent,
    OrderDetailsComponent,
    TruncatePipe,
    ConfirmPurchasePageComponent
  ],
  imports: [
    CommonModule,
    ButtonComponent,
    InputComponent,
    MainRoutingModule
  ]
})
export class MainModule { }
