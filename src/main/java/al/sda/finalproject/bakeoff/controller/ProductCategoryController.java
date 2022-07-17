package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.ProductCategoryDTO;
import al.sda.finalproject.bakeoff.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")

public class ProductCategoryController {

    private ProductCategoryService productCategoryService;
    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService){
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> addCategory(@RequestBody ProductCategoryDTO productCategoryDTO){
        this.productCategoryService.save(productCategoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategoryDTO>>getAllCategories(){
        return new ResponseEntity<>(this.productCategoryService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<ProductCategoryDTO>getCategoryById(@PathVariable Long categoryId){
        return new ResponseEntity<>(this.productCategoryService.findById(categoryId), HttpStatus.OK);
    }
}
