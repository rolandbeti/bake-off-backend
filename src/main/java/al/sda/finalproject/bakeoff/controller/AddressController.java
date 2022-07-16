package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.dto.AddressDTO;
import al.sda.finalproject.bakeoff.service.AccountService;
import al.sda.finalproject.bakeoff.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public ResponseEntity<List<AddressDTO>> getAllAddress(){
        return new ResponseEntity<>(this.addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO>getAddressById(@PathVariable Long id){
        return new ResponseEntity<>(this.addressService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void>deleteAddressById(@PathVariable Long id){
        this.addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Void>addProduct(@RequestBody AddressDTO addressDTO){
        this.addressService.save(addressDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
