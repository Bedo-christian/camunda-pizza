import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'camunda-angular';
  message = '';

  onAffiche(arg: string){
    return this.message = " on click message :"+arg;
  }
}
