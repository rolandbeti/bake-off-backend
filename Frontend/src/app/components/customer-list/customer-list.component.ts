import { CustomerService } from './../../services/customer.service';
import { Customer } from './../../model/customer';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];
  loading: boolean = false;
  displayColumns = [
    'firstName',
    'lastName',
    'email',
    'address',
    'numberOfOrders',
    'totalAmountSpent',
  ];
  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.loadCustomers();
  }
  loadCustomers() {
    this.customerService.getAllCustomers().subscribe((response: Customer[]) => {
      this.customers = response;
    });
  }

  getNumberOfOrders(customer: Customer) {}

  getTotalAmountSpent(customer: Customer) {}
}
