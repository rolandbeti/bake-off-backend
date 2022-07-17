import { Product } from './../model/product';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  rootPath: string = 'http://localhost:8081';
  constructor(private httpClient: HttpClient) {}

  getAllProducts() {
    return this.httpClient.get(`${this.rootPath}/api/products`);
  }

  addProduct(product: Product) {
    return this.httpClient.post(`${this.rootPath}/api/products`, product);
  }

  deleteProduct(id: Number) {
    return this.httpClient.delete(`${this.rootPath}/api/products/${id}`);
  }
}
