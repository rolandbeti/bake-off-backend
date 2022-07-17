import { CategoryService } from './../../services/category.service';
import { Category } from './../../model/category';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css'],
})
export class CategoryListComponent implements OnInit {
  displayColumns = ['ID', 'CategoryName', 'Action'];
  loading: boolean = false;
  categories: Category[];
  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories() {
    this.categoryService
      .getAllCategories()
      .subscribe((response: Category[]) => {
        this.categories = response;
      });
  }
  handleDelete(categoryId: number) {}

  handleUpdate(categoryId: number) {}
}
