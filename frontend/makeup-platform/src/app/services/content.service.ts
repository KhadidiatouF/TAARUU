import { Injectable } from '@angular/core';
import { PortfolioItem, ProductItem, ReviewItem, ServiceOffer } from '../models/makeup.models';

@Injectable({ providedIn: 'root' })
export class ContentService {
  services: ServiceOffer[] = [
    { 
      id: 1, 
      name: 'Signature Makeup', 
      description: 'Un rendu naturel et sophistiqué pour sublimer votre beauté quotidienne.', 
      duration: '45 min', 
      price: 85, 
      image: 'https://images.pexels.com/photos/19161929/pexels-photo-19161929.jpeg', 
      category: 'Essentiel',
      attribution: 'Tochi Joseph on Pexels'
    },
    { 
      id: 2, 
      name: 'Evening Glamour', 
      description: 'Un look intense et captivant pour vos soirées d\'exception.', 
      duration: '75 min', 
      price: 120, 
      image: 'https://images.pexels.com/photos/31735190/pexels-photo-31735190.jpeg', 
      category: 'Événement',
      attribution: 'Angel Rondon on Pexels'
    },
    { 
      id: 3, 
      name: 'Bridal Couture', 
      description: 'Une mise en beauté sur-mesure et intemporelle pour le plus beau jour de votre vie.', 
      duration: '120 min', 
      price: 250, 
      image: 'https://images.pexels.com/photos/13203241/pexels-photo-13203241.jpeg', 
      category: 'Mariage',
      attribution: 'Midory Niwa on Pexels'
    },
    { 
      id: 4, 
      name: 'Editorial / Photo', 
      description: 'Maquillage haute définition pour shootings professionnels et défilés.', 
      duration: '90 min', 
      price: 180, 
      image: 'https://images.pexels.com/photos/31747496/pexels-photo-31747496.jpeg', 
      category: 'Professionnel',
      attribution: 'Oliver Dohrn on Pexels'
    }
  ];

  products: ProductItem[] = [
    { 
      id: 1, 
      name: 'Deep Plum Satin Lipstick', 
      description: 'Couleur intense et fini satiné pour une tenue irréprochable.', 
      price: 14.99, 
      stock: 15, 
      category: 'Lips', 
      brand: 'ROTHE', 
      color: 'Plum', 
      image: 'https://images.unsplash.com/photo-1626895872564-b691b6877b83?auto=format&fit=crop&w=900&q=80', 
      rating: 4.9, 
      reviewCount: 42,
      attribution: 'Qasim Malick on Unsplash'
    },
    { 
      id: 2, 
      name: 'Ruby Rose Satin Lipstick', 
      description: 'Un rouge iconique pour un sourire éclatant.', 
      price: 14.99, 
      stock: 20, 
      category: 'Lips', 
      brand: 'ROTHE', 
      color: 'Red', 
      image: 'https://images.unsplash.com/photo-1542452255191-c85a98f2c5d1?auto=format&fit=crop&w=900&q=80', 
      rating: 4.8, 
      reviewCount: 35,
      attribution: 'Amanda Dalbjörn on Unsplash'
    },
    { 
      id: 3, 
      name: 'Nothing But Nude Satin Lipstick', 
      description: 'La teinte nude parfaite pour un look naturel au quotidien.', 
      price: 14.99, 
      stock: 12, 
      category: 'Lips', 
      brand: 'ROTHE', 
      color: 'Nude', 
      image: 'https://images.unsplash.com/photo-1555050455-f96634b5cba6?auto=format&fit=crop&w=900&q=80', 
      rating: 4.7, 
      reviewCount: 28,
      attribution: 'Karly Jones on Unsplash'
    },
    { 
      id: 4, 
      name: 'Cherry Blossom Satin Lipstick', 
      description: 'Un rose frais et printanier pour sublimer vos lèvres.', 
      price: 14.99, 
      stock: 8, 
      category: 'Lips', 
      brand: 'ROTHE', 
      color: 'Pink', 
      image: 'https://images.unsplash.com/photo-1591360236480-4ed861025fa1?auto=format&fit=crop&w=900&q=80', 
      rating: 4.9, 
      reviewCount: 19,
      attribution: 'Daniele Franchi on Unsplash'
    }
  ];

  portfolio: PortfolioItem[] = [
    { 
      id: 1, 
      title: 'Ethereal Glow', 
      description: 'Maquillage lumineux accentuant la structure osseuse naturelle.', 
      type: 'Beauty', 
      date: 'Juin 2026', 
      image: 'https://images.unsplash.com/photo-1551113006-731674fbb3ff?auto=format&fit=crop&w=900&q=80',
      attribution: 'naeim jafari on Unsplash'
    },
    { 
      id: 2, 
      title: 'Velvet Midnight', 
      description: 'Smokey eye profond et lèvres sombres pour un look dramatique.', 
      type: 'Editorial', 
      date: 'Mai 2026', 
      image: 'https://images.unsplash.com/photo-1581790177468-9d16d4164e90?auto=format&fit=crop&w=900&q=80',
      attribution: 'Marina Kondratova on Unsplash'
    },
    { 
      id: 3, 
      title: 'Golden Hour', 
      description: 'Teintes chaudes et reflets dorés pour une mariée rayonnante.', 
      type: 'Mariage', 
      date: 'Avril 2026', 
      image: 'https://images.unsplash.com/photo-1635954815420-d9ed50b9cfa9?auto=format&fit=crop&w=900&q=80',
      attribution: 'Cesar La Rosa on Unsplash'
    }
  ];

  reviews: ReviewItem[] = [
    { 
      id: 1, 
      clientName: 'Sophie L.', 
      rating: 5, 
      comment: 'Une expérience de luxe absolue. Le maquillage était parfait et a tenu toute la nuit.', 
      image: 'https://images.pexels.com/photos/6954108/pexels-photo-6954108.jpeg',
      attribution: 'George Milton on Pexels'
    },
    { 
      id: 2, 
      clientName: 'Elena M.', 
      rating: 5, 
      comment: 'Les produits ROTHE sont incroyables. Le fond de teint a une couvrance parfaite.', 
      image: 'https://images.pexels.com/photos/16465589/pexels-photo-16465589.jpeg',
      attribution: 'nastaran bahmani on Pexels'
    }
  ];

  getServices() { return this.services; }
  getProducts() { return this.products; }
  getPortfolio() { return this.portfolio; }
  getReviews() { return this.reviews; }
}
