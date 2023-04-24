import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from 'src/app/movie.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit{

  movieDetail: any = []

  constructor(
    private movieSvc: MovieService,
    private router: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let getId = this.router.snapshot.paramMap.get('id')
    console.log("Get ID>>>", getId)
    
    this.getMovieDetails(getId)
  }

  getMovieDetails (id:any) {
    this.movieSvc.getDetails(id).subscribe(async(response) => {
      console.log("Movie Details >>>>>", response)
      this.movieDetail = await response
    })
  }
}
