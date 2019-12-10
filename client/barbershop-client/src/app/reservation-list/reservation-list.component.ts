import { Component, OnInit } from '@angular/core';
import { Reservation } from "../reservation";
import { ReservationService } from "../reservation.service";


@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {

  public filteredReservations: Reservation[];
  public reservations: Reservation[] = [];
  public selectedReservation: Reservation;
  public selectedStatus: string;

  constructor(
    private reservationService: ReservationService
  ) { 
  }
  
  async ngOnInit() : Promise<void> {
    this.selectedStatus = '';
    this.reservations = await this.reservationService.getReservations();
    this.filter();
  }

  onFilterChange(status: string) : void {
    this.selectedStatus = status;
    this.filter();
  }

  onSelectReservation(reservation) {
    this.selectedReservation = reservation;
 }

  filter() {
    this.filteredReservations = this.selectedStatus === ''
    ? this.reservations
    : this.reservations.filter(reservation => reservation.status === this.selectedStatus);
  }

  async onFormSubmit(reservation: Reservation): Promise<void> {
    if (reservation.id > 0) {
      await this.reservationService.updateReservation(reservation)
      this.selectedReservation.name = reservation.name;
      this.selectedReservation.type = reservation.type;
      this.selectedReservation.barber = reservation.barber;
    } else {
      this.selectedReservation.id = Math.floor(Math.random()*1000000);
      this.selectedReservation.name = reservation.name;
      this.selectedReservation.type = reservation.type;
      this.selectedReservation.barber = reservation.barber;
      this.selectedReservation.status = 'ADDED';
      this.reservationService.createReservation(reservation)
                      .then(createdReservation => {
                          this.reservations.push(createdReservation);
                        });
    }
    this.selectedReservation = null;
  }
  
  onNewClick() {
    this.selectedReservation = new Reservation();
  }

  onDeleteClick(id: number) {
    this.reservationService.deleteReservation(id)
    .then(async () => {
      this.selectedReservation = null;
      this.reservations = await this.reservationService.getReservations();
      this.filter();
    })
  }
  onUpdateClick(reservation: Reservation) {
    this.reservationService.updateReservation(reservation)
  }
}
