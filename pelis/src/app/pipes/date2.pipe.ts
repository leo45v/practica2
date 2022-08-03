import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'date2',
})
export class Date2Pipe implements PipeTransform {
  transform(value: Date): string {
    return value.toLocaleDateString('es-BO', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
    });
  }
}
