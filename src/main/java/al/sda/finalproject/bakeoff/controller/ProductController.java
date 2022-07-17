package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.ProductDTO;
import al.sda.finalproject.bakeoff.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>>getAllProducts(){
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO>getProductById(@PathVariable Long id){
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void>deleteProductById(@PathVariable Long id){
        this.productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Void>addProduct(@RequestBody ProductDTO productDTO){
        this.productService.save(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
