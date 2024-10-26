package com.example.restapi.service.impl;

import com.example.restapi.dto.ProductDTO;
import com.example.restapi.entity.Product;
import com.example.restapi.exception.ProductNotFoundException;
import com.example.restapi.mapper.ProductMapper;
import com.example.restapi.repository.ProductRepository;
import com.example.restapi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
        log.info("Successfully fetched all products");
        return products;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        log.info("Successfully created product: {}", savedProduct.getName());
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            log.info("Successfully fetched product with ID: {}", id);
            return productMapper.toDTO(optionalProduct.get());
        }
        throw new ProductNotFoundException("Product not found with ID: " + id);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setName(productDTO.getName());
                product.setPrice(productDTO.getPrice());
                product.setQuantity(productDTO.getQuantity());
                product.setDescription(productDTO.getDescription());
                productRepository.save(product);
                log.info("Successfully updated product with ID: {}", id);
                return productMapper.toDTO(product);
            }
        throw new ProductNotFoundException("Product not found with ID: " + id);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
            log.info("Successfully deleted product with ID: {}", id);
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }
}