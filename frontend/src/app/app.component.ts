import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MovieService } from './movie.service';
import { Router } from '@angular/router';
import { faBars, faList, faSearch } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend';

  searchForm! : FormGroup
  faBars = faBars
  faSearch = faSearch
  faList = faList

  constructor(
    private fb: FormBuilder,
    private movieSvc: MovieService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createSearchForm()
  }

  processSearchForm() {
    this.movieSvc.getSearch(this.searchForm.value.query)
      .subscribe(response => {
        response
        console.log("Response >>> ", response)
        this.movieSvc.movie = response
        console.log("Movie Array >>>", this.movieSvc.movie)
        this.router.navigate(['/search'])
      })
  }

  private createSearchForm() {
    this.searchForm = this.fb.group({
      query : ""
    })
  }
}
