package com.bootexample4.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdReturnsCorrectValue() {
		Product product = new Product();

		Long expectedId = 123L;
		product.setId(expectedId);
		assertEquals(expectedId, product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdReturnsNullByDefault() {
		Product product = new Product();
		assertNull(product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdHandlesMultipleInstancesIndependently() {
		Product product1 = new Product();
		Product product2 = new Product();

		Long product1Id = 111L;

		Long product2Id = 222L;
		product1.setId(product1Id);
		product2.setId(product2Id);
		assertEquals(product1Id, product1.getId());
		assertEquals(product2Id, product2.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	public void getIdHandlesLargeLongValues() {
		Product product = new Product();
		Long largeValue = Long.MAX_VALUE;
		product.setId(largeValue);
		assertEquals(largeValue, product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	public void getIdHandlesSmallLongValues() {
		Product product = new Product();
		Long smallValue = Long.MIN_VALUE;
		product.setId(smallValue);
		assertEquals(smallValue, product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdHandlesZeroValue() {
		Product product = new Product();
		Long zeroValue = 0L;
		product.setId(zeroValue);
		assertEquals(zeroValue, product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	public void getIdReflectsUpdatedValue() {
		Product product = new Product();

		Long initialValue = 100L;

		Long updatedValue = 200L;
		product.setId(initialValue);
		assertEquals(initialValue, product.getId());
		product.setId(updatedValue);
		assertEquals(updatedValue, product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("integration")
	public void getIdThreadSafetyTest() throws InterruptedException {
		Product product = new Product();

		Long valueToSet = 500L;
		product.setId(valueToSet);
		Runnable task = () -> assertEquals(valueToSet, product.getId());
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("invalid")
	public void getIdReturnsNullAfterReset() {
		Product product = new Product();

		Long initialValue = 300L;
		product.setId(initialValue);
		assertEquals(initialValue, product.getId());
		product.setId(null);
		assertNull(product.getId());
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	public void testGetNameReturnsCorrectValue() {

		Product product = new Product();
		String expectedName = "Product Name";
		product.setName(expectedName);

		String actualName = product.getName();

		Assertions.assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	public void testGetNameReturnsNullWhenUninitialized() {

		Product product = new Product();

		String actualName = product.getName();

		Assertions.assertThat(actualName).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	public void testGetNameHandlesEmptyString() {

		Product product = new Product();

		String expectedName = "";
		product.setName(expectedName);

		String actualName = product.getName();

		Assertions.assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	public void testGetNameHandlesSpecialCharacters() {

		Product product = new Product();
		String expectedName = "!@#$%^&*()_+";
		product.setName(expectedName);

		String actualName = product.getName();

		Assertions.assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	public void testGetNameHandlesLongStrings() {

		Product product = new Product();

		String expectedName = "a".repeat(1500);
		product.setName(expectedName);

		String actualName = product.getName();

		Assertions.assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	public void testGetNameReturnsUpdatedValueAfterMultipleUpdates() {

		Product product = new Product();
		String firstName = "First Name";
		String updatedName = "Updated Name";
		product.setName(firstName);
		product.setName(updatedName);

		String actualName = product.getName();

		Assertions.assertThat(actualName).isEqualTo(updatedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	public void testGetNameForSimilarNames() {

		Product product = new Product();
		String expectedName1 = "Product A";
		String expectedName2 = "Product B";
		product.setName(expectedName1);

		String actualName1 = product.getName();
		product.setName(expectedName2);
		String actualName2 = product.getName();

		Assertions.assertThat(actualName1).isEqualTo(expectedName1);
		Assertions.assertThat(actualName2).isEqualTo(expectedName2);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("integration")
	public void testGetNameWhenOtherFieldsAreUninitialized() {

		Product product = new Product();
		String expectedName = "Only Name";
		product.setName(expectedName);

		String actualName = product.getName();

		Assertions.assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	public void getDescriptionReturnsDefaultValueWhenNotSet() {

		Product product = new Product();

		String actualDescription = product.getDescription();

		Assertions.assertNull(actualDescription, "The description should be null when not set.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	public void getDescriptionReturnsUpdatedValue() {

		Product product = new Product();

		String updatedDescription = "Test description";
		product.setDescription(updatedDescription);

		String actualDescription = product.getDescription();

		Assertions.assertEquals(updatedDescription, actualDescription,
				"The description should match the updated value.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	public void getDescriptionHandlesEmptyString() {

		Product product = new Product();
		String emptyDescription = "";
		product.setDescription(emptyDescription);

		String actualDescription = product.getDescription();

		Assertions.assertEquals(emptyDescription, actualDescription, "The description should match an empty string.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	public void getDescriptionHandlesSpecialCharacters() {

		Product product = new Product();
		String specialCharacterDescription = "@$%^&*()";
		product.setDescription(specialCharacterDescription);

		String actualDescription = product.getDescription();

		Assertions.assertEquals(specialCharacterDescription, actualDescription,
				"The description should preserve special characters.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	public void getDescriptionHandlesLongStrings() {

		Product product = new Product();

		String longStringDescription = "a".repeat(10000);
		product.setDescription(longStringDescription);

		String actualDescription = product.getDescription();

		Assertions.assertEquals(longStringDescription, actualDescription,
				"The description should match the extremely long string.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	public void getDescriptionHandlesWhitespace() {

		Product product = new Product();
		String descriptionWithWhitespace = "  Test  ";
		product.setDescription(descriptionWithWhitespace);

		String actualDescription = product.getDescription();

		Assertions.assertEquals(descriptionWithWhitespace, actualDescription,
				"The description should preserve leading and trailing whitespace.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("integration")
	public void getDescriptionHandlesConcurrentAccess() throws InterruptedException {

		Product product = new Product();

		String concurrentDescription = "Concurrent Test";
		product.setDescription(concurrentDescription);

		Runnable accessTask = () -> {
			String actualDescription = product.getDescription();
			Assertions.assertEquals(concurrentDescription, actualDescription,
					"Concurrent access should retrieve the correct description.");
		};
		Thread thread1 = new Thread(accessTask);
		Thread thread2 = new Thread(accessTask);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	public void getDescriptionHandlesReservedKeywords() {

		Product product = new Product();

		String reservedKeywordDescription = "null";
		product.setDescription(reservedKeywordDescription);

		String actualDescription = product.getDescription();

		Assertions.assertEquals(reservedKeywordDescription, actualDescription,
				"The description should match the reserved keyword string.");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	public void getDescriptionReturnsNullAfterExplicitNull() {

		Product product = new Product();
		product.setDescription("Initial value");
		product.setDescription(null);

		String actualDescription = product.getDescription();

		Assertions.assertNull(actualDescription,
				"The description should return null after being explicitly set to null.");
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	public void verifyPriceRetrievalAfterSet() {
		Product product = new Product();

		product.setPrice(100.75);
		assertEquals(100.75, product.getPrice(), 0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	public void verifyDefaultPriceZero() {
		Product product = new Product();

		product.setPrice(0.0);
		assertEquals(0.0, product.getPrice(), 0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("invalid")
	public void verifyHandlingOfNegativePrice() {
		Product product = new Product();

		product.setPrice(-100.50);
		assertEquals(-100.50, product.getPrice(), 0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	public void verifyRetrievalOfHighPriceValues() {
		Product product = new Product();

		product.setPrice(999999.99);
		assertEquals(999999.99, product.getPrice(), 0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	public void verifyFractionalPriceRetrieval() {
		Product product = new Product();

		product.setPrice(10.99);
		assertEquals(10.99, product.getPrice(), 0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("integration")
	public void validatePriceAfterChainingChanges() {
		Product product = new Product();

		product.setPrice(50.0);

		product.setPrice(75.0);
		assertEquals(75.0, product.getPrice(), 0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	public void verifyNoStateModificationByGetPrice() {
		Product product = new Product();
		product.setId(10L);
		product.setName("Test Product");

		product.setDescription("Sample Description");
		product.setPrice(150.75);

		assertEquals(150.75, product.getPrice(), 0.0);
		assertEquals(10L, product.getId());
		assertEquals("Test Product", product.getName());
		assertEquals("Sample Description", product.getDescription());
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	public void verifyEdgeCaseDecimalPrecision() {
		Product product = new Product();

		double edgeCaseValue = 0.0000001;
		product.setPrice(edgeCaseValue);
		assertEquals(edgeCaseValue, product.getPrice(), 0.00000001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	public void verifyDefaultValueWhenPriceUnset() {
		Product product = new Product();

		assertEquals(0.0, product.getPrice(), 0.0);
	}

}