import { Injectable } from '@angular/core';
import { Hero } from 'app/domains/hero';
import { HEROES } from 'app/mocks/heroes.mock';
@Injectable()
export class HeroService {
  getHeroes(): Promise<Hero[]> {
    return Promise.resolve(HEROES);
  }
}