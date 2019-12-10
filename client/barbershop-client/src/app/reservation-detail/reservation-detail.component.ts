import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Reservation } from "../reservation";
import { ReservationService } from "../reservation.service";

@Component({
  selector: 'app-reservation-detail',
  templateUrl: './reservation-detail.component.html',
  styleUrls: ['./reservation-detail.component.css']
})
export class ReservationDetailComponent implements OnInit {

  public reservation: Reservation = null;

  constructor(
    private route: ActivatedRoute,
    private reservationService: ReservationService
  ) { }
  
  async ngOnInit(): Promise<void> {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reservation = await this.reservationService.getReservation(id);
  }
}