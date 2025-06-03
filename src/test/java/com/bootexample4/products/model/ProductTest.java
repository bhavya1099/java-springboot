package com.bootexample4.products.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	public void getIdReturnsNullWhenIdIsNotInitialized() {
		Product product = new Product();
		assertNull(product.getId(), "Expected getId to return null when id is not initialized");
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdReturnsValueSetBySetId() {
		Product product = new Product();

		Long expectedId = 123L;
		product.setId(expectedId);
		assertEquals(expectedId, product.getId(), "Expected getId to return the value set by setId");
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdReturnsCorrectValueAfterIdChange() {
		Product product = new Product();

		Long initialId = 123L;

		Long newId = 456L;
		product.setId(initialId);
		product.setId(newId);
		assertEquals(newId, product.getId(), "Expected getId to return the new value after id change");
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	public void getIdReturnsNegativeValueSetBySetId() {
		Product product = new Product();

		Long negativeId = -789L;
		product.setId(negativeId);
		assertEquals(negativeId, product.getId(), "Expected getId to return the negative value set by setId");
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdReturnsPositiveValueSetBySetId() {
		Product product = new Product();

		Long positiveId = 789L;
		product.setId(positiveId);
		assertEquals(positiveId, product.getId(), "Expected getId to return the positive value set by setId");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	public void getNameReturnsNameWhenNameExists() {

		Product product = new Product();

		String expectedName = "Sample Product";
		product.setName(expectedName);

		String actualName = product.getName();

		assertEquals(expectedName, actualName, "The returned name should be the same as the set name.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	public void getDescriptionWithNullValue() {

		Product product = new Product();

		String description = product.getDescription();

		assertNull(description, "The description should be null when not set.");
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	public void defaultPriceCheck() {

		Product product = new Product();

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice, 0.01);
	}

}