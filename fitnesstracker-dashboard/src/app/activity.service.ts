import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {


  url="http://ibmfsd07.iiht.tech:8011/customers";
  constructor(private http:Http) { }

  getlist(info)
  {
return this.http.get(this.url+'/'+info);
  }
}
