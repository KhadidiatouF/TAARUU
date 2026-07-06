export interface ServiceOffer {
  id: number;
  name: string;
  description: string;
  duration: string;
  price: number;
  image: string;
  category: string;
  attribution: string;
}

export interface ProductItem {
  id: number;
  name: string;
  description: string;
  price: number;
  salePrice?: number;
  stock: number;
  category: string;
  brand: string;
  color: string;
  image: string;
  rating: number;
  reviewCount: number;
  attribution: string;
}

export interface PortfolioItem {
  id: number;
  title: string;
  description: string;
  type: string;
  date: string;
  image: string;
  attribution: string;
}

export interface ReviewItem {
  id: number;
  clientName: string;
  rating: number;
  comment: string;
  image: string;
  attribution: string;
}
