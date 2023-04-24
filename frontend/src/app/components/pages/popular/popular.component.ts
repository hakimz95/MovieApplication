import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../../movie.service';

@Component({
  selector: 'app-popular',
  templateUrl: './popular.component.html',
  styleUrls: ['./popular.component.css']
})
export class PopularComponent implements OnInit{

  movie: any = []

  constructor(
    private movieSvc: MovieService
  ) {}

  ngOnInit(): void {
    this.movieSvc.getPopular()
    this.popularMovie()
  }

  popularMovie() {
    this.movieSvc.getPopular().subscribe(
      response => {
        console.log(response)
        this.movie = response
      }
    )
  }

  
}
