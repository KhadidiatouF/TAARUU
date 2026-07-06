import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.scss'
})
export class AdminDashboardComponent {
  stats = [
    { label: 'Réservations', value: '128' },
    { label: 'Chiffre d’affaires', value: '18.4k €' },
    { label: 'Commandes', value: '94' },
    { label: 'Produits vendus', value: '421' }
  ];
}
