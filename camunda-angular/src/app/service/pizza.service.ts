import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {Pizza} from "../model/pizza";
import {endpoints} from "../../config/endpoints";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PizzaService {
    private apiUrl: string = environment.apiUrl;

    //headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) {}

  //get all pizza
  public getAllPizza(): Observable<Pizza[]> {
    return this.http.get<Pizza[]>(this.apiUrl+endpoints.GET_PIZZA)
      .pipe(catchError(this.errorHandler));
  }


  /**
   * Write code on Method
   *
   * @return response()
   */
  create(pizza:Pizza): Observable<any> {

    return this.http.post(this.apiUrl + endpoints.POST_PIZZA, JSON.stringify(pizza), this.httpOptions)

      .pipe(
        catchError(this.errorHandler)
      );
  }


  /**
  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }
  */

  /**
   * Write code on Method
   *
   * @return response()
   */
  errorHandler(error:any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent  ) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
