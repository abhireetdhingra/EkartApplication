package com.example.ecom_project.controller;

import com.example.ecom_project.model.Product;
import com.example.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController
{
    @Autowired
    ProductService service;
    @RequestMapping("/")
    public String greet()
    {
        System.out.println("Inside greet method");
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK); //sending status code as well
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id)
    {
        Product product=service.getProductById(id);
        if(product!=null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile)
    {
        try
        {
            Product product1=service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable int productId)
    {
        Product product=service.getProductById(productId);
        byte[] imageFile=product.getImageData();
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
                                                 @RequestPart Product product,
                                                 @RequestPart MultipartFile imageFile)
    {
        try
        {
            Product updatedProduct=service.updateProduct(id,product,imageFile);
            if(updatedProduct!=null)
                return new ResponseEntity<>("Product updated.",HttpStatus.OK);
            else
                return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
        }
        catch (IOException e)
        {
            return new ResponseEntity<>("Some error while updating product",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id)
    {
        Product product=service.getProductById(id);
        if(product!=null)
        {
            service.deleteProduct(id);
            return new ResponseEntity<>("Product deleted",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Product not deleted!",HttpStatus.NOT_FOUND);
    }
}
