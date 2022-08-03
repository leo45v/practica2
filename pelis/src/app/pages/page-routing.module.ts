import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActorComponent } from './actor/actor.component';
import { MovieComponent } from './movie/movie.component';
import { MoviesComponent } from './movies/movies.component';
import { SearchResultsComponent } from './search-results/search-results.component';

const routes: Routes = [
  {
    path: 'movies',
    component: MoviesComponent,
  },
  {
    path: 'actores',
    component: ActorComponent,
  },
  {
    path: 'generos',
    component: MoviesComponent,
  },
  {
    path: 'search',
    redirectTo: '/',
    pathMatch: 'full',
  },
  {
    path: 'movie/:id',
    component: MovieComponent,
  },
  {
    path: 'search/:title',
    component: SearchResultsComponent,
  },
  {
    path: '',
    redirectTo: 'movies',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {}
