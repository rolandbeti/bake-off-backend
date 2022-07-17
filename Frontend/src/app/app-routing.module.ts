import { CategoryListComponent } from './components/category-list/category-list.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  { path: 'products/add', component: AddProductComponent },
  { path: 'categories', component: CategoryListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
