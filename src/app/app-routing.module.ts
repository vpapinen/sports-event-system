import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { CreateEventComponent } from './add-event/create-event.component';
import { CreateStudentComponent } from './create-student/create-student.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent,canActivate:[AuthGaurdService] },
  { path: 'addemployee', component: AddEmployeeComponent,canActivate:[AuthGaurdService]},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  { path: 'add-event', component: CreateEventComponent },
  { path: 'add-student', component: CreateStudentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
