import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationFormComponent } from './reservation-form.component';
import { Component, OnInit, OnChanges, Input, Output, EventEmitter  } from '@angular/core'; 
import { Reservation } from '../Reservation';

describe('ReservationFormComponent', () => {
  let component: ReservationFormComponent;
  let fixture: ComponentFixture<ReservationFormComponent>;

  @Input() reservation: Reservation

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
