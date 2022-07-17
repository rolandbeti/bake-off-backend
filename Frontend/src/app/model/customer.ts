import { Account } from './account';
import { Address } from './address';
export class Customer {
  id: number;
  firstName: string;
  lastName: string;
  address: Address;
  email: string;
  account: Account;
}
