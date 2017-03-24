import { Injectable } from '@angular/core';
import { Hero } from '../domains/hero';
import { HEROES } from '../mocks/heroes.mock';
@Injectable()
export class HeroService {
  getHeroes(): Promise<Hero[]> {
    return Promise.resolve(HEROES);
  }
}