import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-top-rated',
  templateUrl: './top-rated.component.html',
  styleUrls: ['./top-rated.component.css']
})
export class TopRatedComponent implements OnInit{

  movie: any = []

  constructor(
    private movieSvc: MovieService
  ) {}

  ngOnInit(): void {
    this.movieSvc.getTopRated()
    this.topRatedMovie()
  }

  topRatedMovie() {
    this.movieSvc.getTopRated().subscribe(
      response => {
        console.log(response)
        this.movie = response
      }
    )
  }
}
