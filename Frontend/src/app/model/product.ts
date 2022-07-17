import { Category } from './category';
export class Product {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  category: Category;

  constructor() {}
}
