package com.example.restapi.controller;

import com.example.restapi.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product API", description = "API for managing products")
public interface ProductController {

    @Operation(summary = "Get all products")
    @GetMapping("/products")
    ResponseEntity<List<ProductDTO>> getAllProducts();

    @Operation(summary = "Create a new product")
    @PostMapping("/products")
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO);

    @Operation(summary = "Update an existing product")
    @PutMapping("/products/{id}")
    ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    @Operation(summary = "Delete a product")
    @DeleteMapping("/products/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
