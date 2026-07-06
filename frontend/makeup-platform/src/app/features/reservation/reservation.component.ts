import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ContentService } from '../../services/content.service';

@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.scss'
})
export class ReservationComponent {
  services: any[] = [];
  selectedServiceId = 1;
  bookingDate = '';
  bookingTime = '';
  customerName = '';
  phone = '';
  email = '';
  remarks = '';
  submitted = false;

  constructor(private contentService: ContentService) {
    this.services = this.contentService.getServices();
  }

  submit() {
    this.submitted = true;
  }
}
