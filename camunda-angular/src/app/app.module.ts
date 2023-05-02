import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from "@angular/router";

import { AppComponent } from './app.component';
import { PizzaComponent } from './pizza/pizza.component';
import { CommandeComponent } from './commande/commande.component';
import { ClientComponent } from './client/client.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DataService} from "./data.service";
import { AddPizzaComponent } from './pizza/add-pizza/add-pizza.component';
import { PizzaListComponent } from './pizza/pizza-list/pizza-list.component';
import {PizzaService} from "./service/pizza.service";
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

const routes: Routes = [
  {path: "client", component: ClientComponent},
  {path:"commande", component: CommandeComponent},
  {path:"pizza/dispo", component: PizzaListComponent},
  {path:"pizza/add", component: AddPizzaComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    PizzaComponent,
    CommandeComponent,
    ClientComponent,
    AddPizzaComponent,
    PizzaListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    CommonModule,
    FormsModule, ReactiveFormsModule
  ],
  providers: [DataService, PizzaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
