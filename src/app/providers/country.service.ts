import { Injectable } from '@angular/core';
import { Country } from 'app/domains/country';
import { COUNTRIES } from 'app/mocks/countries.mock';
@Injectable()
export class CountryService {
  getCountries(): Promise<Country[]> {
    return Promise.resolve(COUNTRIES);
  }
}