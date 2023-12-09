package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ayush/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    //creating employee REST API
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return  productRepository.save(product);
    }
    //Getting Product by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id)
    {
        Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product does not exists with id:" + id));
        return  ResponseEntity.ok(product);
    }
    //Updating Product by id REST API
    @PutMapping("{id}")
    public  ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product productDetails){
        Product updateProduct= productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product does not exists with id:" + id));
        updateProduct.setName(productDetails.getName());
        updateProduct.setQuantity(productDetails.getQuantity());
        updateProduct.setPrice(productDetails.getPrice());
        productRepository.save(updateProduct);
        return  ResponseEntity.ok(updateProduct);

    }
    //Deleting Product REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id){
        Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product does not exists with id:" + id));
        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
