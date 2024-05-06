import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'truncate'
})
export class TruncatePipe implements PipeTransform {

    transform(value: String, maxLength: number): String {
      if (value.length > maxLength) {
        return value.substring(0, maxLength) + '...';
      }
      return value;
    }
  }

