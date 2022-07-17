import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  rootPath: string = 'http://localhost:8081';
  constructor() {}
}
