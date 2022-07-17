package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.OrderLineDTO;
import al.sda.finalproject.bakeoff.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class OrderLineController {
    private final OrderLineService orderLineService;
    @Autowired
    public OrderLineController(OrderLineService orderLineService){
        this.orderLineService = orderLineService;
    }

    @GetMapping("/order-lines")
    public ResponseEntity<List<OrderLineDTO>>getAllOrderLines(){
        return new ResponseEntity<>(this.orderLineService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/order-lines/{orderLineId}")
    public ResponseEntity<OrderLineDTO>getOrderLineById(@PathVariable Long orderLineId){
        return new ResponseEntity<>(this.orderLineService.findById(orderLineId),HttpStatus.OK );
    }

    @PostMapping("/order-lines")
    public ResponseEntity<Void>addOrderLine(@RequestBody OrderLineDTO orderLineDTO){
        this.orderLineService.save(orderLineDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/order-lines/{orderLineId}")
    public ResponseEntity<Void>deleteOrderLineById(@PathVariable Long orderLineId){
        this.orderLineService.deleteById(orderLineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
