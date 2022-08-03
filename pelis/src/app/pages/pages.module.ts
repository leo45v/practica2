import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesComponent } from './pages.component';
import { MoviesComponent } from './movies/movies.component';
import { ComponentsModule } from '../components/components.module';
import { PagesRoutingModule } from './page-routing.module';
import { LayoutModule } from '../layout/layout.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { GenresComponent } from './genres/genres.component';
import { ActorComponent } from './actor/actor.component';
import { MovieComponent } from './movie/movie.component';
import { PipesModule } from '../pipes/pipes.module';
import { SearchResultsComponent } from './search-results/search-results.component';

@NgModule({
  declarations: [
    PagesComponent,
    MoviesComponent,
    GenresComponent,
    ActorComponent,
    MovieComponent,
    SearchResultsComponent,
  ],
  exports: [PagesComponent],
  imports: [
    PagesRoutingModule,
    ComponentsModule,
    CommonModule,
    NgbModule,
    LayoutModule,
    PipesModule,
  ],
})
export class PagesModule {}
