import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private apiURL = environment.apiUrl

  constructor(
    private httpClient: HttpClient
  ) { }

  //Popular
  getPopular(): Observable<any> {
    return this.httpClient.get(`${this.apiURL}/popular`)
  }

  //Top Rated
  getTopRated(): Observable<any> {
    return this.httpClient.get(`${this.apiURL}/topRated`)
  }

  //Trending
  getTrending(): Observable<any> {
    return this.httpClient.get(`${this.apiURL}/trending`)
  }

  //Search | Query
  getSearch(query: string): Observable<any> {
    const params = new HttpParams().set("query", query)
    console.log(query)
    return this.httpClient.get(`${this.apiURL}/search`, {params})
  }
  
}
