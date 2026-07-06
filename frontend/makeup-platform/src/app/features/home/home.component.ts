import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ContentService } from '../../services/content.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  services: any[] = [];
  products: any[] = [];
  portfolio: any[] = [];
  reviews: any[] = [];

  categories = [
    { name: 'Eyes', image: 'https://images.pexels.com/photos/6859626/pexels-photo-6859626.jpeg', attribution: 'behrouz sasani on Pexels' },
    { name: 'Lips', image: 'https://images.pexels.com/photos/7290746/pexels-photo-7290746.jpeg', attribution: 'MART PRODUCTION on Pexels' },
    { name: 'Face', image: 'https://images.pexels.com/photos/36288121/pexels-photo-36288121.jpeg', attribution: 'El gringo photo on Pexels' },
    { name: 'Skin', image: 'https://images.pexels.com/photos/4465831/pexels-photo-4465831.jpeg', attribution: 'www.kaboompics.com on Pexels' }
  ];

  heroImage = 'https://images.unsplash.com/photo-1551113006-731674fbb3ff?auto=format&fit=crop&w=1920&q=80';
  heroAttribution = 'naeim jafari on Unsplash';
  
  featuredPaletteImage = 'https://images.unsplash.com/photo-1533562389935-457b1ae48a39?auto=format&fit=crop&w=1920&q=80';
  featuredPaletteAttribution = 'Siora Photography on Unsplash';

  constructor(private contentService: ContentService) {
    this.services = this.contentService.getServices();
    this.products = this.contentService.getProducts();
    this.portfolio = this.contentService.getPortfolio();
    this.reviews = this.contentService.getReviews();
  }
}
