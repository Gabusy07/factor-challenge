import { TestBed } from '@angular/core/testing';

import { CalDiscountService } from './cal-discount.service';

describe('CalDiscountService', () => {
  let service: CalDiscountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalDiscountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
