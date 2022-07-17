import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  private rootUrl: string = 'http://localhost:8081';

  constructor(private httpClient: HttpClient) {}

  getAllCategories() {
    return this.httpClient.get(`${this.rootUrl}/api/categories`);
  }
}
