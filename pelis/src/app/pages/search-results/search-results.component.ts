import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.scss'],
})
export class SearchResultsComponent implements OnInit {
  searchText: string = '';
  page = 1;
  movies: Movie[] = [];
  totalPages: number = 0;
  totalResults: number = 0;

  constructor(
    private readonly movieService: MovieService,
    private readonly activatedRoute: ActivatedRoute,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(({ page }) => {
      if (!page) return;
      this.page =
        isNaN(Number(page)) || Number(page) <= 0 ? 1 : Number(page) || 1;
      this.fetchMovies();
    });

    this.activatedRoute.params.subscribe(({ title, page }) => {
      if (title || page) {
        this.searchText = title;
        this.fetchMovies();
      } else {
        this.router.navigate(['/']);
      }
    });
  }

  public onChangePage(page: number): void {
    this.page = page;
    if (this.page > this.totalPages) {
      this.page = this.totalPages;
    }
    if (this.page <= 0) {
      this.page = 1;
    }
    this.router.navigate(['/search', this.searchText], {
      queryParams: { page: this.page },
    });
  }

  public fetchMovies() {
    this.movieService
      .getMoviesByTitle(this.searchText, this.page)
      .subscribe((result) => {
        this.movies = result.data || [];
        this.totalPages = result.total;
        this.totalResults = result.results;
      });
  }
}
