import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LawyerComponent } from './components/lawyer/lawyer.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "lawyer", component: LawyerComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
