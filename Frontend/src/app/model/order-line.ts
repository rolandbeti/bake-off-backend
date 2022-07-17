import { Product } from './product';

export class OrderLine {
  id: number;
  product: Product;
  quantity: number;
  lineAmount: number;
}
