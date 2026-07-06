import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContentService } from '../../services/content.service';

@Component({
  selector: 'app-portfolio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './portfolio.component.html',
  styleUrl: './portfolio.component.scss'
})
export class PortfolioComponent {
  portfolio: any[] = [];

  constructor(private contentService: ContentService) {
    this.portfolio = this.contentService.getPortfolio();
  }
}
