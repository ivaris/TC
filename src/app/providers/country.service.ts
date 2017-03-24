import { Injectable } from '@angular/core';
import { Country } from '../domains/country';
import { COUNTRIES } from '../mocks/countries.mock';
@Injectable()
export class CountryService {
  getCountries(): Promise<Country[]> {
    return Promise.resolve(COUNTRIES);
  }
}