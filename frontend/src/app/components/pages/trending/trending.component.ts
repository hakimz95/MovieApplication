import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../../movie.service';

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.css']
})
export class TrendingComponent implements OnInit {

  movie: any = []

  constructor (
    private movieSvc: MovieService
  ) {}

  ngOnInit(): void {
      this.movieSvc.getTrending()
      this.trendingMovie()
  }

  trendingMovie() {
    this.movieSvc.getTrending().subscribe(
      response => {
        console.log("Trending Response >>>",response)
        this.movie = response
      }
    )
  }

}
