import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

//import { ExampleComponent }  from './components/example.component';
import { HeroService }  from './providers/hero.service';
import { CountryService }  from './providers/country.service';
import { AddTravelComponent }  from './components/addtravel.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule
  ],
  declarations: [
    AddTravelComponent
  ],
  providers: [
    HeroService,
    CountryService
  ],
  bootstrap: [

   AddTravelComponent
  ]
})
export class AppModule { }
