import { OrderLine } from './order-line';
import { Customer } from './customer';
export class Order {
  orderDate: Date;
  id: number;
  customer: Customer;
  totalAmount: number;
  orderLines: OrderLine[];
  status: string;
}
