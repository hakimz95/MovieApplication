import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PopularComponent } from './components/pages/popular/popular.component';
import { TopRatedComponent } from './components/pages/top-rated/top-rated.component';
import { TrendingComponent } from './components/pages/trending/trending.component';
import { SearchComponent } from './components/pages/search/search.component';
import { DetailComponent } from './components/pages/detail/detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { WatchlistComponent } from './components/watchlist.component';

@NgModule({
  declarations: [
    AppComponent,
    PopularComponent,
    TopRatedComponent,
    TrendingComponent,
    SearchComponent,
    DetailComponent,
    WatchlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
