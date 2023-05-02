import {outputAst} from "@angular/compiler";
import {Component, OnInit, Input,Output,EventEmitter} from '@angular/core';
import {DataService} from "../data.service";

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent {
 // titreArticle: string = "Pizza Title";
  //pricePizza: number = 120;
  altImg: string = "Titre alt images";
  urlImg: string = "https://via.placeholder.com/400x250";

  comment: string = "Commentaire";
  @Input() pricePizza: string;
  @Input() titreArticle: string;
  // @ts-ignore
  @Output() info: EventEmitter<string> = new EventEmitter();
   dispo: boolean = true;

  totalLike: number = 0;
  constructor(){}

  onLike(){
    this.totalLike++;
    this.info.emit(this.titreArticle);
  }
}
