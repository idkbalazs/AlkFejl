import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ReservationListComponent } from "../reservation-list/reservation-list.component";
import { ReservationFormComponent } from '../reservation-form/reservation-form.component';
import { ReservationDetailComponent } from '../reservation-detail/reservation-detail.component';
import { AuthGuard } from '../auth.guard';
import { LoginFormComponent } from '../login-form/login-form.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/reservations',
    pathMatch: 'full'
  },
  {
    path: 'reservations',
    component: ReservationListComponent,
    canActivate: [AuthGuard],
    data: {
      roles: ['ROLE_USER']
    }
  },
  {
    path: 'reservations/new',
    component: ReservationFormComponent,
    canActivate: [AuthGuard],
    data: {
      roles: ['ROLE_USER']
    }
  },
  {
    path: 'reservations/:id',
    component: ReservationDetailComponent,
    canActivate: [AuthGuard],
    data: {
      roles: ['ROLE_USER']
    }
  },
  {
    path: 'login',
    component: LoginFormComponent
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }