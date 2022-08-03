import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PopularityPipe } from './popularity.pipe';
import { Date2Pipe } from './date2.pipe';

@NgModule({
  declarations: [PopularityPipe, Date2Pipe],
  imports: [CommonModule],
  exports: [PopularityPipe, Date2Pipe],
})
export class PipesModule {}
