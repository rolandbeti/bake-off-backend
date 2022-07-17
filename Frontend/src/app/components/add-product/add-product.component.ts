import { ProductService } from './../../services/product.service';
import { Product } from './../../model/product';
import { CategoryService } from './../../services/category.service';
import { Category } from './../../model/category';
import { FileService } from './../../services/file.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent implements OnInit {
  selectedFiles?: FileList;
  currentFile?: File;
  errorMsg = '';
  categories: Category[];

  form = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(60)]],
    description: ['', Validators.required],
    category: [undefined, Validators.required],
    price: [, Validators.required],
  });

  constructor(
    private router: Router,
    private fileService: FileService,
    private categoryService: CategoryService,
    private fb: FormBuilder,
    private productService: ProductService
  ) {}

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

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }
  upload(): void {
    this.errorMsg = '';

    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
      if (file) {
        this.currentFile = file;
        //  Need to add product id
        this.fileService.upload(1, this.currentFile).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              console.log(Math.round((100 * event.loaded) / event.total));
            } else if (event instanceof HttpResponse) {
            }
          },
          (err: any) => {
            console.log(err);

            if (err.error && err.error.responseMessage) {
              this.errorMsg = err.error.responseMessage;
            } else {
              this.errorMsg = 'Error occurred while uploading a file!';
            }
            this.currentFile = undefined;
          }
        );
      }
      this.router.navigate([`/`]);
      this.selectedFiles = undefined;
    }
  }

  addProduct() {
    let product: Product = new Product();
    // product.category = this.category;
    // product.description = this.description;
    // product.name = this.name;
    // product.price = this.price;

    let description = this.form.controls['description'].value;
    let name = this.form.controls['name'].value;
    let price = this.form.controls['price'].value;
    let category = this.form.controls['category'].value;
    product.category = category;
    product.name = name;
    product.price = price;
    product.description = description;
    console.log(product);
    this.productService.addProduct(product).subscribe((response) => {
      console.log(response);
      this.router.navigate(['/products']);
    });
    // console.log('Category Id: ' + this.categoryId);
  }
}
