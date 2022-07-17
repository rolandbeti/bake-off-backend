import { OrderService } from './../../services/order.service';
import { Order } from './../../model/order';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  orders: Order[];
  panelOpenState = false;
  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.loadOrders();
  }
  loadOrders() {
    this.orderService.getAllOrders().subscribe((response: Order[]) => {
      this.orders = response;
      console.log(this.orders);
    });
  }
}
