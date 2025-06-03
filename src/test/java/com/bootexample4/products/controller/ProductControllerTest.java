package com.bootexample4.products.controller;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import org.junit.jupiter.api.*;
import org.springframework.web.bind.annotation.*;

public class ProductControllerTest {

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
	@Tag("valid")
	public void getAllProductsReturnsProductListWhenRepositoryHasProducts() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("Product1");
		product1.setDescription("Description1");
		product1.setPrice(10.0);
		Product product2 = new Product();
		product2.setId(2L);
		product2.setName("Product2");
		product2.setDescription("Description2");
		product2.setPrice(20.0);
		List<Product> mockProducts = Arrays.asList(product1, product2);
		when(productRepository.findAll()).thenReturn(mockProducts);
		List<Product> result = productController.getAllProducts();
		assertThat(result).isEqualTo(mockProducts);
	}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
@Tag("valid")
public void getAllProductsReturnsEmptyListWhenRepositoryIsEmpty() {
    when(productRepository.findAll()).thenReturn(Collections.emptyList());
    List<Product> result = productController.getAllProducts();
    assertThat(result).isEmpty();
}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
	@Tag("invalid")
	public void getAllProductsHandlesNullRepositoryGracefully() {

		productController = new ProductController();

		productController.productRepository = null;
		List<Product> result = productController.getAllProducts();

		assertThat(result).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
@Tag("boundary")
public void getAllProductsInvokesRepositoryFindAllOnce() {
    when(productRepository.findAll()).thenReturn(Collections.emptyList());
    productController.getAllProducts();
    verify(productRepository, times(1)).findAll();
}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
	@Tag("valid")
	public void getAllProductsReturnsProperProductAttributes() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("Product1");
		product1.setDescription("Description1");
		product1.setPrice(10.0);
		Product product2 = new Product();
		product2.setId(2L);
		product2.setName("Product2");
		product2.setDescription("Description2");
		product2.setPrice(20.0);
		List<Product> mockProducts = Arrays.asList(product1, product2);
		when(productRepository.findAll()).thenReturn(mockProducts);
		List<Product> result = productController.getAllProducts();
		assertThat(result).isNotEmpty();
		assertThat(result).containsExactly(product1, product2);
	}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
	@Tag("valid")
	public void getAllProductsHandlesDuplicateProducts() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("Product1");
		product1.setDescription("Description1");
		product1.setPrice(10.0);
		Product duplicateProduct = new Product();
		duplicateProduct.setId(1L);
		duplicateProduct.setName("Product1");
		duplicateProduct.setDescription("Description1");
		duplicateProduct.setPrice(10.0);
		List<Product> mockProducts = Arrays.asList(product1, duplicateProduct);
		when(productRepository.findAll()).thenReturn(mockProducts);
		List<Product> result = productController.getAllProducts();
		assertThat(result).containsExactly(product1, duplicateProduct);
	}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
@Tag("boundary")
public void getAllProductsHandlesNullReturnFromRepository() {
    when(productRepository.findAll()).thenReturn(null);
    List<Product> result = productController.getAllProducts();

    assertThat(result).isNull();
}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
@Tag("invalid")
public void getAllProductsHandlesExceptionFromRepository() {
    when(productRepository.findAll()).thenThrow(new RuntimeException("Repository failure"));
    try {
        productController.getAllProducts();
    } catch (Exception e) {
        assertThat(e).isInstanceOf(RuntimeException.class);
        assertThat(e.getMessage()).isEqualTo("Repository failure");
    }
}

	/*
	 * ROOST_METHOD_HASH=getAllProducts_c7c755eb4e
	 * ROOST_METHOD_SIG_HASH=getAllProducts_e267ceea76
	 *
	 */@Test
	@Tag("boundary")
	public void getAllProductsHandlesLargeProductList() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("Product1");
		product1.setDescription("Description1");
		product1.setPrice(10.0);
		Product product2 = new Product();
		product2.setId(2L);
		product2.setName("Product2");
		product2.setDescription("Description2");
		product2.setPrice(20.0);
		List<Product> mockProducts = Arrays.asList(product1, product2);

		when(productRepository.findAll()).thenReturn(mockProducts);
		List<Product> result = productController.getAllProducts();
		assertThat(result.size()).isEqualTo(mockProducts.size());
		assertThat(result).isEqualTo(mockProducts);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@BeforeEach
	public void setup() {
		Mockito.reset(productRepository);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("valid")
	public void createProductWithValidDetails() {
		Product validProduct = new Product();

		validProduct.setName("Valid Name");

		validProduct.setDescription("Valid Description");

		validProduct.setPrice(100.0);
		Mockito.when(productRepository.save(validProduct)).thenReturn(validProduct);
		Product result = productController.createProduct(validProduct);
		assertThat(result).isNotNull();
		assertThat(result.getName()).isEqualTo(validProduct.getName());
		assertThat(result.getDescription()).isEqualTo(validProduct.getDescription());
		assertThat(result.getPrice()).isEqualTo(validProduct.getPrice());
		Mockito.verify(productRepository, Mockito.times(1)).save(validProduct);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("invalid")
	public void createProductWithNullProduct() {
		assertThrows(IllegalArgumentException.class, () -> productController.createProduct(null));
		Mockito.verify(productRepository, Mockito.never()).save(Mockito.any(Product.class));
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("invalid")
	public void createProductWithoutName() {
		Product productWithoutName = new Product();

		productWithoutName.setDescription("Valid Description");

		productWithoutName.setPrice(100.0);
		Mockito.when(productRepository.save(productWithoutName)).thenReturn(productWithoutName);
		Product result = productController.createProduct(productWithoutName);
		assertThat(result).isNotNull();
		assertThat(result.getName()).isNull();
		Mockito.verify(productRepository, Mockito.times(1)).save(productWithoutName);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("invalid")
	public void createProductWithoutDescription() {
		Product productWithoutDescription = new Product();

		productWithoutDescription.setName("Valid Name");

		productWithoutDescription.setPrice(100.0);
		Mockito.when(productRepository.save(productWithoutDescription)).thenReturn(productWithoutDescription);
		Product result = productController.createProduct(productWithoutDescription);
		assertThat(result).isNotNull();
		assertThat(result.getDescription()).isNull();
		Mockito.verify(productRepository, Mockito.times(1)).save(productWithoutDescription);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("invalid")
	public void createProductWithoutPrice() {
		Product productWithoutPrice = new Product();

		productWithoutPrice.setName("Valid Name");

		productWithoutPrice.setDescription("Valid Description");
		Mockito.when(productRepository.save(productWithoutPrice)).thenReturn(productWithoutPrice);
		Product result = productController.createProduct(productWithoutPrice);
		assertThat(result).isNotNull();

		assertThat(result.getPrice()).isEqualTo(0.0);
		Mockito.verify(productRepository, Mockito.times(1)).save(productWithoutPrice);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("integration")
	public void createProductWithRepositoryFailure() {
		Product validProduct = new Product();

		validProduct.setName("Valid Name");

		validProduct.setDescription("Valid Description");

		validProduct.setPrice(100.0);
		Mockito.when(productRepository.save(validProduct)).thenThrow(new RuntimeException("Repository failure"));
		assertThrows(RuntimeException.class, () -> productController.createProduct(validProduct));
		Mockito.verify(productRepository, Mockito.times(1)).save(validProduct);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("invalid")
	public void createDuplicateProduct() {
		Product duplicateProduct = new Product();

		duplicateProduct.setName("Duplicate Name");

		duplicateProduct.setDescription("Duplicate Description");

		duplicateProduct.setPrice(200.0);
		Mockito.when(productRepository.save(duplicateProduct)).thenReturn(duplicateProduct);
		Product result1 = productController.createProduct(duplicateProduct);
		Product result2 = productController.createProduct(duplicateProduct);
		assertThat(result1).isNotNull();
		assertThat(result2).isNotNull();
		Mockito.verify(productRepository, Mockito.times(2)).save(duplicateProduct);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("invalid")
	public void createProductWithInvalidPrice() {
		Product productWithInvalidPrice = new Product();

		productWithInvalidPrice.setName("Valid Name");

		productWithInvalidPrice.setDescription("Valid Description");

		productWithInvalidPrice.setPrice(-10.0);
		assertThrows(IllegalArgumentException.class, () -> productController.createProduct(productWithInvalidPrice));
		Mockito.verify(productRepository, Mockito.never()).save(productWithInvalidPrice);
	}

	/*
	 * ROOST_METHOD_HASH=createProduct_60409495d0
	 * ROOST_METHOD_SIG_HASH=createProduct_5b0158b3eb
	 *
	 */@Test
	@Tag("boundary")
	public void createProductWithBoundaryPriceValue() {
		Product productWithBoundaryPrice = new Product();

		productWithBoundaryPrice.setName("Boundary Name");

		productWithBoundaryPrice.setDescription("Valid Description");

		productWithBoundaryPrice.setPrice(0.01);
		Mockito.when(productRepository.save(productWithBoundaryPrice)).thenReturn(productWithBoundaryPrice);
		Product result = productController.createProduct(productWithBoundaryPrice);
		assertThat(result).isNotNull();
		assertThat(result.getPrice()).isEqualTo(0.01);
		Mockito.verify(productRepository, Mockito.times(1)).save(productWithBoundaryPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("valid")
	public void validProductIdReturnsProduct() {

		Long validId = 1L;

		Product mockProduct = mock(Product.class);
		when(mockProduct.getName()).thenReturn("Sample Product");
		when(mockProduct.getDescription()).thenReturn("Sample Description");
		when(mockProduct.getPrice()).thenReturn(100.0);
		when(productRepository.findById(validId)).thenReturn(Optional.of(mockProduct));

		ResponseEntity<Product> response = productController.getProductById(validId);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(mockProduct, response.getBody());
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("invalid")
	public void nonExistentProductIdReturnsNotFound() {

		Long invalidId = 999L;
		when(productRepository.findById(invalidId)).thenReturn(Optional.empty());

		ResponseEntity<Product> response = productController.getProductById(invalidId);

		assertEquals(404, response.getStatusCodeValue());
		assertNull(response.getBody());
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("integration")
	public void repositoryThrowsExceptionDuringLookup() {

		Long idWithException = 3L;
		when(productRepository.findById(idWithException)).thenThrow(new RuntimeException("Database Error"));

		assertThrows(RuntimeException.class, () -> {
			productController.getProductById(idWithException);
		});
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("invalid")
	public void nullProductIdInputThrowsException() {

		assertThrows(IllegalArgumentException.class, () -> {

			productController.getProductById(null);
		});
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("boundary")
	public void borderProductIdMinValueLookup() {

		Long minId = 0L;
		when(productRepository.findById(minId)).thenReturn(Optional.empty());

		ResponseEntity<Product> response = productController.getProductById(minId);

		assertEquals(404, response.getStatusCodeValue());
		assertNull(response.getBody());
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("boundary")
	public void borderProductIdMaxValueLookup() {

		Long maxId = Long.MAX_VALUE;
		when(productRepository.findById(maxId)).thenReturn(Optional.empty());

		ResponseEntity<Product> response = productController.getProductById(maxId);

		assertEquals(404, response.getStatusCodeValue());
		assertNull(response.getBody());
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("invalid")
	public void negativeProductIdReturnsNotFound() {

		Long negativeId = -1L;
		when(productRepository.findById(negativeId)).thenReturn(Optional.empty());

		ResponseEntity<Product> response = productController.getProductById(negativeId);

		assertEquals(404, response.getStatusCodeValue());
		assertNull(response.getBody());
	}

	/*
	 * ROOST_METHOD_HASH=getProductById_5e209a8195
	 * ROOST_METHOD_SIG_HASH=getProductById_5e209a8195
	 *
	 */@Test
	@Tag("valid")
	public void productResponseIncludesExpectedFields() {

		Long validId = 2L;

		Product mockProduct = mock(Product.class);
		when(mockProduct.getName()).thenReturn("Sample Product");
		when(mockProduct.getDescription()).thenReturn("Description");
		when(mockProduct.getPrice()).thenReturn(299.99);
		when(productRepository.findById(validId)).thenReturn(Optional.of(mockProduct));

		ResponseEntity<Product> response = productController.getProductById(validId);

		Product responseBody = response.getBody();
		assertNotNull(responseBody);
		assertEquals(mockProduct.getName(), responseBody.getName());
		assertEquals(mockProduct.getDescription(), responseBody.getDescription());
		assertEquals(mockProduct.getPrice(), responseBody.getPrice(), 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("valid")
	public void updateExistingProductSuccessfully() {

		Long productId = 1L;
		Product existingProduct = new Product();
		existingProduct.setName("Old Name");
		existingProduct.setDescription("Old Description");
		existingProduct.setPrice(100.0);
		Product updatedProductData = new Product();
		updatedProductData.setName("Updated Name");
		updatedProductData.setDescription("Updated Description");
		updatedProductData.setPrice(150.0);
		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		when(productRepository.save(existingProduct)).thenReturn(updatedProductData);

		ResponseEntity<Product> response = productController.updateProduct(productId, updatedProductData);

		assertNotNull(response.getBody());
		assertEquals(updatedProductData.getName(), response.getBody().getName());
		assertEquals(updatedProductData.getDescription(), response.getBody().getDescription());
		assertEquals(updatedProductData.getPrice(), response.getBody().getPrice());
		assertEquals(200, response.getStatusCodeValue());
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("invalid")
	public void updateNonExistentProduct() {

		Long productId = 999L;
		Product updatedProductData = new Product();
		updatedProductData.setName("Updated Name");
		updatedProductData.setDescription("Updated Description");
		updatedProductData.setPrice(150.0);
		when(productRepository.findById(productId)).thenReturn(Optional.empty());

		ResponseEntity<Product> response = productController.updateProduct(productId, updatedProductData);

		assertEquals(404, response.getStatusCodeValue());
		verify(productRepository, never()).save(any(Product.class));
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("boundary")
	public void updateProductWithPartialData() {

		Long productId = 1L;
		Product existingProduct = new Product();
		existingProduct.setName("Old Name");
		existingProduct.setDescription("Old Description");
		existingProduct.setPrice(100.0);
		Product updatedProductData = new Product();
		updatedProductData.setName("Updated Name");

		updatedProductData.setDescription(null);
		updatedProductData.setPrice(150.0);
		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		when(productRepository.save(existingProduct)).thenReturn(existingProduct);

		ResponseEntity<Product> response = productController.updateProduct(productId, updatedProductData);

		assertNotNull(response.getBody());
		assertEquals("Updated Name", response.getBody().getName());
		assertEquals("Old Description", response.getBody().getDescription());
		assertEquals(150.0, response.getBody().getPrice());
		assertEquals(200, response.getStatusCodeValue());
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("valid")
	public void verifyRepositorySaveCall() {

		Long productId = 1L;
		Product existingProduct = new Product();
		existingProduct.setName("Old Name");
		existingProduct.setDescription("Old Description");
		existingProduct.setPrice(100.0);
		Product updatedProductData = new Product();
		updatedProductData.setName("Updated Name");
		updatedProductData.setDescription("Updated Description");
		updatedProductData.setPrice(150.0);
		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));

		productController.updateProduct(productId, updatedProductData);

		verify(productRepository, times(1)).save(existingProduct);
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("invalid")
	public void updateFailureDueToRepositoryError() {

		Long productId = 1L;
		Product existingProduct = new Product();
		existingProduct.setName("Old Name");
		existingProduct.setDescription("Old Description");
		existingProduct.setPrice(100.0);
		Product updatedProductData = new Product();
		updatedProductData.setName("Updated Name");
		updatedProductData.setDescription("Updated Description");
		updatedProductData.setPrice(150.0);
		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		when(productRepository.save(existingProduct)).thenThrow(new RuntimeException("Database error"));

		assertThrows(RuntimeException.class, () -> {
			productController.updateProduct(productId, updatedProductData);
		});
		verify(productRepository, times(1)).save(existingProduct);
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("invalid")
	public void updateProductWithNullId() {

		Long productId = null;
		Product updatedProductData = new Product();
		updatedProductData.setName("Updated Name");
		updatedProductData.setDescription("Updated Description");
		updatedProductData.setPrice(150.0);

		ResponseEntity<Product> response = productController.updateProduct(productId, updatedProductData);

		assertEquals(400, response.getStatusCodeValue());
	}

	/*
	 * ROOST_METHOD_HASH=updateProduct_850f4057dd
	 * ROOST_METHOD_SIG_HASH=updateProduct_850f4057dd
	 *
	 */@Test
	@Tag("invalid")
	public void updateProductWithNullObject() {

		Long productId = 1L;
		Product updatedProductData = null;

		ResponseEntity<Product> response = productController.updateProduct(productId, updatedProductData);

		assertEquals(400, response.getStatusCodeValue());
		verify(productRepository, never()).findById(anyLong());
		verify(productRepository, never()).save(any(Product.class));
	}

	/*
	 * ROOST_METHOD_HASH=deleteProduct_032472106e
	 * ROOST_METHOD_SIG_HASH=deleteProduct_032472106e
	 *
	 */@BeforeEach
	void setUp() {
		productRepository = Mockito.mock(ProductRepository.class);
		productController = new ProductController();

		java.lang.reflect.Field repositoryField = ProductController.class.getDeclaredField("productRepository");
		repositoryField.setAccessible(true);
		repositoryField.set(productController, productRepository);
	}

}