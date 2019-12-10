import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule, MatButtonToggleModule, MatIconModule, MatButtonModule, MatMenuModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReservationListComponent } from './reservation-list/reservation-list.component';
import { ReservationFormComponent } from './reservation-form/reservation-form.component';
import { ReservationDetailComponent } from './reservation-detail/reservation-detail.component';
import { RoutingModule } from './routing/routing.module';
import { StatusFilterComponent } from './status-filter/status-filter.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { LoginFormComponent } from './login-form/login-form.component';



@NgModule({
  declarations: [
    AppComponent,
    ReservationListComponent,
    ReservationFormComponent,
    ReservationDetailComponent,
    StatusFilterComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonToggleModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatMenuModule,
    NgbModule,
    RoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
