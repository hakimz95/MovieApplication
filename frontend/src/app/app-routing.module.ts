import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PopularComponent } from './components/pages/popular/popular.component';
import { TopRatedComponent } from './components/pages/top-rated/top-rated.component';
import { TrendingComponent } from './components/pages/trending/trending.component';
import { DetailComponent } from './components/pages/detail/detail.component';
import { SearchComponent } from './components/pages/search/search.component';
import { WatchlistComponent } from './components/pages/watchlist/watchlist.component';

const routes: Routes = [
  { path: 'detail/:id', component: DetailComponent },
  { path: 'search', component: SearchComponent },
  { path: 'popular', component: PopularComponent },
  { path: 'trending', component: TrendingComponent},
  { path: 'topRated', component: TopRatedComponent },
  { path: 'watchlist', component: WatchlistComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
