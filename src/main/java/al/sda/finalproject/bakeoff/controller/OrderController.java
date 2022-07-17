package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.OrderDTO;
import al.sda.finalproject.bakeoff.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>>getAllOrders(){
        return new ResponseEntity<>(this.orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("orders/{orderId}")
    ResponseEntity<OrderDTO>getOrderById(@PathVariable Long orderId){
        return new ResponseEntity<>(this.orderService.findById(orderId),HttpStatus.OK);
    }

    @DeleteMapping("orders/{orderId}")
    ResponseEntity<Void>deleteOrderById(@PathVariable Long orderId){
        this.orderService.deleteById(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
