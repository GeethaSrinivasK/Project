import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Register} from './register.model'
@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private url='http://localhost:8011/register';
  
  constructor(private http:Http) { }
  register(reg:Register)
  {
    return this.http.post(this.url,reg);
  }
  validate()
  {
    return this.http.get(this.url);
  }
}
