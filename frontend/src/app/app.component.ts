import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MovieService } from './movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend';

  searchForm! : FormGroup

  constructor(
    private fb: FormBuilder,
    private movieSvc: MovieService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createSearchForm()
  }

  processSearchForm() {
    console.log("Searching >>>")
    this.movieSvc.getSearch(this.searchForm.value.query)
      .subscribe(response => {
        response
        console.log(response)
        this.router.navigate(['/search'])
      })
  }

  private createSearchForm() {
    this.searchForm = this.fb.group({
      query : " "
    })
  }
}
