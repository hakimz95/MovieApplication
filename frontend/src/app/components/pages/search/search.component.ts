import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../../movie.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  movie: any = []

  constructor(
    private movieSvc: MovieService
  ) {}

  ngOnInit(): void {
      //this.movieSvc.getSearch()
      this.movie = this.movieSvc.movie
      // this.searchMovie()
  }

  searchMovie() {
    // this.movieSvc.getSearch().subscribe(
    //   response => {
    //     console.log(response)
    //     this.movie = response
    //   }
    // )
  }

}
