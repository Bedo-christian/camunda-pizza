import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
 data = [
   {
     altImg: "Titre alt images",
     urlImg: "https://via.placeholder.com/400x250"
   }
   ];
  constructor() { }
}
