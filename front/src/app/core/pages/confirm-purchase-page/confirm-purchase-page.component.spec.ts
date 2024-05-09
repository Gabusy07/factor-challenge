import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmPurchasePageComponent } from './confirm-purchase-page.component';

describe('ConfirmPurchasePageComponent', () => {
  let component: ConfirmPurchasePageComponent;
  let fixture: ComponentFixture<ConfirmPurchasePageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConfirmPurchasePageComponent]
    });
    fixture = TestBed.createComponent(ConfirmPurchasePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
