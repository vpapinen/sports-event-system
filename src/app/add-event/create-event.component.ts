import { EventService } from './../service/event.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Event } from 'src/app/model/event/event';

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {

  event: Event = new Event();
  submitted = false;

  constructor(private eventService: EventService,
    private router: Router) { }

  ngOnInit() {
  }

  newStudent(): void {
    this.submitted = false;
    this.event = new Event();
  }

  onSubmit() {
    this.submitted = true;
    this.eventService
    .createStudent(this.event).subscribe(data => {
      alert("Event created successfully.");
    }, 
    error => console.log(error));
  }
}
