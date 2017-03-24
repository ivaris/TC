import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http'

import { CountryService }  from './providers/country.service';
import { AddTravelComponent }  from './components/addtravel.component';
import { RoutingModule }     from './routing.module';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RoutingModule
  ],
  declarations: [
    AddTravelComponent
  ],
  providers: [
    CountryService
  ],
  bootstrap: [

   AddTravelComponent
  ]
})
export class AppModule { }
