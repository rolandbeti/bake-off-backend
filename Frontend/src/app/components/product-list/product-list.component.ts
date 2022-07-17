import { Product } from './../../model/product';
import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  products: Product[];
  displayColumns = ['image', 'name', 'category', 'price', 'Action'];
  loading: boolean = false;
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.loadProducts();
  }
  loadProducts() {
    this.productService.getAllProducts().subscribe((response: Product[]) => {
      this.products = response;
    });
  }

  addProduct(product: Product) {
    this.productService.addProduct(product).subscribe((response) => {
      console.log(response);
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe();
  }
  handleUpdate(product: Product) {}
}
