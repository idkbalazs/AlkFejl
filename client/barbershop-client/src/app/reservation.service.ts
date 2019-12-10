import { Injectable } from '@angular/core';
import { Reservation } from "./reservation";
import { AuthService, httpOptions } from './auth.service';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})

export class ReservationService {
  

  private reservationUrl = 'http://localhost:8080/reservations';

  constructor(
    private http: HttpClient
  ) { }

  getReservations(): Promise<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.reservationUrl}`, httpOptions).toPromise();
  }

  getReservation(id: number): Promise<Reservation> {
    return this.http.get<Reservation>(`${this.reservationUrl}/${id}`, httpOptions).toPromise();
  }

  createReservation(issue: Reservation): Promise<Reservation> {
    return this.http.post<Reservation>(`${this.reservationUrl}`, issue, httpOptions).toPromise();
  }

  updateReservation(issue: Reservation): Promise<Reservation> {
    return this.http.put<Reservation>(`${this.reservationUrl}/${issue.id}`, issue, httpOptions).toPromise();
  }

  deleteReservation(id): Promise<Reservation> {
    return this.http.delete<Reservation>(`${this.reservationUrl}/${id}`, httpOptions).toPromise();
  }
}