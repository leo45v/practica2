import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  public searchText: string = '';
  constructor(public readonly router: Router) {}

  ngOnInit(): void {}

  searchMovies() {
    if (!this.searchText) return;
    this.router.navigate(['/search', this.searchText]);
  }
}
