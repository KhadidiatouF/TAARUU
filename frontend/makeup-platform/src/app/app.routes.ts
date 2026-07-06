import { Routes } from '@angular/router';
import { HomeComponent } from './features/home/home.component';
import { ReservationComponent } from './features/reservation/reservation.component';
import { ShopComponent } from './features/shop/shop.component';
import { PortfolioComponent } from './features/portfolio/portfolio.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'realisations', component: PortfolioComponent },
  { path: 'boutique', component: ShopComponent },
  { path: '**', redirectTo: '' }
];
