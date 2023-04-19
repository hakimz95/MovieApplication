import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PopularComponent } from './components/popular.component';
import { TopRatedComponent } from './components/top-rated.component';
import { TrendingComponent } from './components/trending.component';
import { DetailComponent } from './components/detail.component';
import { SearchComponent } from './components/search.component';

const routes: Routes = [
  { path: 'detail', component: DetailComponent },
  { path: 'search', component: SearchComponent },
  { path: 'popular', component: PopularComponent },
  { path: 'trending', component: TrendingComponent},
  { path: 'topRated', component: TopRatedComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
