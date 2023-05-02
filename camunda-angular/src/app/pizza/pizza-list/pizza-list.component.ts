import {Component, OnInit} from '@angular/core';
import {PizzaService} from "../../service/pizza.service";
import {Pizza} from "../../model/pizza";
import {Observable, of} from "rxjs";
import {AppDataState, DataStateEnum} from "../../state/state";
import {catchError, map, startWith} from "rxjs/operators";

@Component({
  selector: 'app-pizza-list',
  templateUrl: './pizza-list.component.html',
  styleUrls: ['./pizza-list.component.css']
})
export class PizzaListComponent implements OnInit{


  pizzas$:Observable<AppDataState<Pizza[]>> | null= null;
  readonly DataStateEnum = DataStateEnum;

  constructor(private pizzaService : PizzaService){
  }

  ngOnInit(): void {
      this.onGetAllPizza();
  }



  onGetAllPizza() {
    this.pizzas$= this.pizzaService.getAllPizza().pipe(
      map(data=>{
        console.log(data);
        return ({dataState:DataStateEnum.LOADED,data:data})
      }),
      startWith({dataState:DataStateEnum.LOADING}),
      catchError(err=>of({dataState:DataStateEnum.ERROR, errorMessage:err.message}))
    );
  }
}
