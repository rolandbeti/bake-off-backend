import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private rootUrl: string = 'http://localhost:8081';
  constructor(private httpClient: HttpClient) {}

  getAllOrders() {
    return this.httpClient.get(`${this.rootUrl}/api/orders`);
  }
}
