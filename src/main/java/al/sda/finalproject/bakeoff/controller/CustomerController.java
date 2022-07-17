package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.CustomerDTO;
import al.sda.finalproject.bakeoff.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")

public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this. customerService =  customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return new ResponseEntity<>(this.customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO>getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(this.customerService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void>deleteCustomerById(@PathVariable Long id){
        this.customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Void>addAuthority(@RequestBody CustomerDTO customerDTO){
        this.customerService.save(customerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
