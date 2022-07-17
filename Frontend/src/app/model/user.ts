import { Role } from './role';
import { Address } from './address';

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  address: Address;
  role: Role;
  password: string;
  username: string;
}
