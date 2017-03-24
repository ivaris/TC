import { Component, OnInit } from '@angular/core';
import { Country } from '../domains/country';
import { CountryService }  from '../providers/country.service';

@Component({
  selector: 'tc-app',
  templateUrl: 'app/views/addtravel.view.html',
  styleUrls: ['app/styles/addtravel.style.css'],
  providers: [CountryService]
})
export class AddTravelComponent implements OnInit {

  title = 'Tour of Countries';
  countries: Country[];
  selectedCountry: Country;
  constructor(private countryService: CountryService) { }
  getCountries(): void {
    this.countryService.getCountries().then(countries => this.countries = countries);
  }
  ngOnInit(): void {
    this.getCountries();
  }
  onSelect(country: Country): void {
    this.selectedCountry = country;
  }
}
