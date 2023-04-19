import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-popular',
  templateUrl: './popular.component.html',
  styleUrls: ['./popular.component.css']
})
export class PopularComponent implements OnInit{

  popular!: any[]

  constructor(
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
      this.getPopular()
  }

  getPopular() {
    this.httpClient.get<any>('http://localhost:8080/api/popular').subscribe(
      response => {
        console.log(response)
        this.popular = response
      }
    )
  }
}
