import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-top-rated',
  templateUrl: './top-rated.component.html',
  styleUrls: ['./top-rated.component.css']
})
export class TopRatedComponent implements OnInit{

  topRated!: any[]

  constructor(
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
      this.getTopRated()
  }

  getTopRated() {
    this.httpClient.get<any>('http://localhost:8080/api/topRated').subscribe(
      response => {
        console.log(response)
        this.topRated = response
      }
    )
  }
}
