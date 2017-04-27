import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTravelComponent }   from './components/addtravel.component';
const routes: Routes = [
  { path: '', redirectTo: '/addtravel', pathMatch: 'full' },
  { path: 'addtravel',  component: AddTravelComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class RoutingModule {}