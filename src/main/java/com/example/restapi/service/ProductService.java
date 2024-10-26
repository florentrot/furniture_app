package com.example.restapi.service;

import com.example.restapi.dto.ProductDTO;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * Retrieves all products.
     *
     * @return a list of ProductDTO objects.
     */
    List<ProductDTO> getAllProducts();

    /**
     * Creates a new product.
     *
     * @param productDTO the product data transfer object.
     * @return the created ProductDTO.
     */
    ProductDTO createProduct(ProductDTO productDTO);

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product.
     * @return the ProductDTO of the retrieved product.
     */
    ProductDTO getProductById(Long id);

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update.
     * @param productDTO the product data transfer object with updated information.
     * @return the updated ProductDTO.
     */
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete.
     */
    void deleteProduct(Long id);
}
