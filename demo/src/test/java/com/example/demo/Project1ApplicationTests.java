package com.example.demo;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class Project1ApplicationTests {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	void contextLoads() {
		// This test method is left empty
		// Its purpose is to check if the application context loads without errors
	}

	@Test
	void getAllProducts_shouldReturnListOfProducts() {
		// Arrange
		when(productRepository.findAll()).thenReturn(Collections.singletonList(new Product()));

		// Act
		var result = productService.getAllProducts();

		// Assert
		assertFalse(result.isEmpty());
	}

	@Test
	void createProduct_withValidProduct_shouldReturnSavedProduct() {
		// Arrange
		Product inputProduct = new Product();
		inputProduct.setName("Test Product");
		inputProduct.setQuantity(10);
		inputProduct.setPrice(300); // Using BigDecimal for the price

		// Act
		var result = productService.createProduct(inputProduct);

		// Assert
		assertNotNull(result);
		assertEquals(inputProduct.getName(), result.getName());
		assertEquals(inputProduct.getQuantity(), result.getQuantity());
		assertEquals(inputProduct.getPrice(), result.getPrice());
	}

	@Test
	void getProductById_withValidId_shouldReturnProduct() {
		// Arrange
		long productId = 1L;
		when(productRepository.findById(productId)).thenReturn(Optional.of(new Product()));

		// Act
		var result = productService.getProductById(productId);

		// Assert
		assertNotNull(result);
	}

	@Test
	void getProductById_withInvalidId_shouldThrowException() {
		// Arrange
		long invalidProductId = 999L;
		when(productRepository.findById(invalidProductId)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(ResourceNotFoundException.class, () -> productService.getProductById(invalidProductId));
	}

	@Test
	void updateProduct_withValidIdAndProduct_shouldReturnUpdatedProduct() {
		// Arrange
		long productId = 1L;
		Product existingProduct = new Product(1L, "Existing Product", 5, 15L);
		Product updatedProduct = new Product(); // Using the default constructor

		updatedProduct.setId(existingProduct.getId()); // Set the ID from the existing product
		updatedProduct.setName("Updated Product");
		updatedProduct.setQuantity(10);
		updatedProduct.setPrice(25L);

		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

		// Act
		var result = productService.updateProduct(productId, updatedProduct);

		// Assert
		assertNotNull(result);
		assertEquals(updatedProduct.getName(), result.getName());
		assertEquals(updatedProduct.getQuantity(), result.getQuantity());
		assertEquals(updatedProduct.getPrice(), result.getPrice());
	}

	@Test
	void updateProduct_withInvalidId_shouldThrowException() {
		// Arrange
		long invalidProductId = 999L;
		Product updatedProduct = new Product(invalidProductId,"Updated Product", 10L, 25L);

		when(productRepository.findById(invalidProductId)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(ResourceNotFoundException.class, () -> productService.updateProduct(invalidProductId, updatedProduct));
	}

	@Test
	void deleteProduct_withValidId_shouldDeleteProduct() {
		// Arrange
		long productId = 1L;
		Product existingProduct = new Product(1L, "Existing Product", 5, 15L);

		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));

		// Act
		assertDoesNotThrow(() -> productService.deleteProduct(productId));

		// Assert
		verify(productRepository).delete(existingProduct);
	}

	@Test
	void deleteProduct_withInvalidId_shouldThrowException() {
		// Arrange
		long invalidProductId = 999L;

		when(productRepository.findById(invalidProductId)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(ResourceNotFoundException.class, () -> productService.deleteProduct(invalidProductId));
	}
}
