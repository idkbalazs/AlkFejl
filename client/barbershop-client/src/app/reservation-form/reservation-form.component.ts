import { Component, OnChanges, Input, Output, EventEmitter  } from '@angular/core'; 
import { Reservation } from '../Reservation';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnChanges{

  @Input() reservation: Reservation
  public model: Reservation
  @Output() onSubmit = new EventEmitter<Reservation>();

  constructor() { }

  ngOnChanges() : void {
    this.model = Object.assign({}, this.reservation);
  }

  submit(form: NgForm) : void {
    if (!form.valid) {
      return;
    }
    this.onSubmit.emit(this.model);
  }

  

}
