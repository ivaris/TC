import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { ExampleComponent }  from './components/example.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule
  ],
  declarations: [
    ExampleComponent
  ],
  bootstrap: [ ExampleComponent ]
})
export class AppModule { }
