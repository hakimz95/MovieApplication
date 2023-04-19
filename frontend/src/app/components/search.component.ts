import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  search!: any[]

  constructor(
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {
      
  }

  getSearch() {
    this.httpClient.get<any>('http://localhost:8080/api/search/').subscribe(
      response => {
        console.log(response)
        this.search = response
      }
    )
  }

}
