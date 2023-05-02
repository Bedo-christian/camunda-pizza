import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from "@angular/forms";
import {PizzaService} from "../../service/pizza.service";
import {Pizza} from "../../model/pizza";

@Component({
  selector: 'app-add-pizza',
  templateUrl: './add-pizza.component.html',
  styleUrls: ['./add-pizza.component.css']
})
export class AddPizzaComponent  implements OnInit{

  addPizzaform: Pizza = new Pizza();

  @ViewChild("Pizza")
  pizzaForm!: NgForm;
  isSubmitted: boolean = false;


  constructor(private fb:FormBuilder, private pizzaService: PizzaService) {}

  ngOnInit(): void {
  }

  onSaveProduct(isValid: any) {
    this.isSubmitted = true;
    if (isValid) {
      this.pizzaService.create(this.addPizzaform).subscribe( data=> {
        console.log("DATA RESPONSE :"+JSON.stringify(data))
        console.log("STATUS_CODE :"+data.status)
          /*if (data != null && data.body != null) {
            if (data != null && data.body != null) {
              var resultData = data.body;
              if (resultData != null && resultData.isSuccess) {
                this.toastr.success(resultData.message);
                setTimeout(() => {
                  this.router.navigate(['/Home']);
                }, 500);
              }
            }
          }*/
        });
/*        async error => {
          this.toastr.error(error.message);
          setTimeout(() => {
            this.router.navigate(['/Home']);
          }, 500);
        });*/
    }
  }

}
