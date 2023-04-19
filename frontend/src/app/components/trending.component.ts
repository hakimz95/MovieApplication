import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.css']
})
export class TrendingComponent implements OnInit {

  trending!: any[]

  constructor (
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
      this.getTrending()
  }

  getTrending() {
    this.httpClient.get<any>('http://localhost:8080/api/trending').subscribe(
      response => {
        console.log(response)
        this.trending = response
      }
    )
  }

}
