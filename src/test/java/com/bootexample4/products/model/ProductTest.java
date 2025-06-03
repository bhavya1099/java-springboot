package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@BeforeEach
	void setUp() {
		product = new Product();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdWhenIdIsSet - Should return correct ID when ID is set")
	void getIdWhenIdIsSet() {

		Long expectedId = 123L;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertEquals(expectedId, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdWhenIdIsNull - Should return null when ID is not set")
	void getIdWhenIdIsNull() {

		Long actualId = product.getId();

		assertNull(actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithMaxLongValue - Should return Long.MAX_VALUE when ID is set to maximum value")
	void getIdWithMaxLongValue() {

		Long expectedId = Long.MAX_VALUE;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertEquals(expectedId, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithMinLongValue - Should return Long.MIN_VALUE when ID is set to minimum value")
	void getIdWithMinLongValue() {

		Long expectedId = Long.MIN_VALUE;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertEquals(expectedId, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithZeroValue - Should return 0L when ID is set to zero")
	void getIdWithZeroValue() {

		Long expectedId = 0L;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertEquals(expectedId, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("getIdWithNegativeValue - Should return negative value when ID is set to negative number")
	void getIdWithNegativeValue() {

		Long expectedId = -100L;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertEquals(expectedId, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("multipleCallsToGetId - Should return same value on multiple calls")
	void multipleCallsToGetId() {

		Long expectedId = 456L;
		product.setId(expectedId);

		Long firstCall = product.getId();
		Long secondCall = product.getId();
		Long thirdCall = product.getId();

		assertEquals(expectedId, firstCall);
		assertEquals(expectedId, secondCall);
		assertEquals(expectedId, thirdCall);
		assertEquals(firstCall, secondCall);
		assertEquals(secondCall, thirdCall);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdAfterUpdate - Should return updated ID after changing the ID")
	void getIdAfterUpdate() {

		Long initialId = 100L;
		Long updatedId = 200L;
		product.setId(initialId);

		Long firstId = product.getId();
		product.setId(updatedId);
		Long secondId = product.getId();

		assertEquals(initialId, firstId);
		assertEquals(updatedId, secondId);
		assertNotEquals(firstId, secondId);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@BeforeEach
	void setUp() {
		product = new Product();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void getNameWhenNameIsSet() {
		String expectedName = "Test Product";
		product.setName(expectedName);
		String actualName = product.getName();
		assertEquals(expectedName, actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	void getNameWhenNameIsNull() {
		String actualName = product.getName();
		assertNull(actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	void getNameWhenNameIsEmpty() {
		String expectedName = "";
		product.setName(expectedName);
		String actualName = product.getName();
		assertEquals(expectedName, actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void getNameWithSpecialCharacters() {
		String expectedName = "Product@#$%^&*()_+-=[]{}|;':\",./<>?";
		product.setName(expectedName);
		String actualName = product.getName();
		assertEquals(expectedName, actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	void getNameWithVeryLongString() {
		StringBuilder longNameBuilder = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			longNameBuilder.append("a");
		}
		String expectedName = longNameBuilder.toString();
		product.setName(expectedName);
		String actualName = product.getName();
		assertEquals(expectedName, actualName);
		assertEquals(1000, actualName.length());
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void getNameWithLeadingAndTrailingSpaces() {
		String expectedName = "   Product Name   ";
		product.setName(expectedName);
		String actualName = product.getName();
		assertEquals(expectedName, actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void getNameAfterUpdate() {
		String initialName = "Initial Product";
		String updatedName = "Updated Product";
		product.setName(initialName);
		assertEquals(initialName, product.getName());
		product.setName(updatedName);
		String actualName = product.getName();
		assertEquals(updatedName, actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void getNameWithUnicodeCharacters() {
		String expectedName = "מוצר בעברית 🚀 منتج عربي 中文产品";
		product.setName(expectedName);
		String actualName = product.getName();
		assertEquals(expectedName, actualName);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@BeforeEach
	void setUp() {
		product = new Product();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionWhenSet - Should return correct description when set")
	void getDescriptionWhenSet() {

		String expectedDescription = "This is a high-quality product with excellent features";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEqualTo(expectedDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWhenNull - Should return null when description not set")
	void getDescriptionWhenNull() {

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWhenEmpty - Should return empty string when description is empty")
	void getDescriptionWhenEmpty() {

		String emptyDescription = "";
		product.setDescription(emptyDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEmpty();
		assertThat(actualDescription).isEqualTo("");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWithLongText - Should return long description without truncation")
	void getDescriptionWithLongText() {

		StringBuilder longDescriptionBuilder = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			longDescriptionBuilder.append("This is a very long description text. ");
		}
		String longDescription = longDescriptionBuilder.toString();
		product.setDescription(longDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).hasSize(longDescription.length());
		assertThat(actualDescription).isEqualTo(longDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionWithSpecialCharacters - Should return description with special characters intact")
	void getDescriptionWithSpecialCharacters() {

		String specialDescription = "Description with @#$% special chars & symbols\n\tNew line and tab";
		product.setDescription(specialDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEqualTo(specialDescription);
		assertThat(actualDescription).contains("@#$%");
		assertThat(actualDescription).contains("\n\t");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionAfterMultipleChanges - Should return latest description after multiple updates")
	void getDescriptionAfterMultipleChanges() {

		String firstDescription = "First description";
		String secondDescription = "Updated description";
		String finalDescription = "Final description version";
		product.setDescription(firstDescription);
		product.setDescription(secondDescription);
		product.setDescription(finalDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEqualTo(finalDescription);
		assertThat(actualDescription).isNotEqualTo(firstDescription);
		assertThat(actualDescription).isNotEqualTo(secondDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionWithUnicodeCharacters - Should handle unicode characters correctly")
	void getDescriptionWithUnicodeCharacters() {

		String unicodeDescription = "תיאור בעברית 中文描述 Описание émojis: 😀🎉";
		product.setDescription(unicodeDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEqualTo(unicodeDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWithWhitespaceOnly - Should return whitespace string when set")
	void getDescriptionWithWhitespaceOnly() {

		String whitespaceDescription = "   \t\n   ";
		product.setDescription(whitespaceDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEqualTo(whitespaceDescription);
		assertThat(actualDescription.trim()).isEmpty();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionConsistency - Should return same value on multiple calls")
	void getDescriptionConsistency() {

		String description = "Consistent description";
		product.setDescription(description);

		String firstCall = product.getDescription();
		String secondCall = product.getDescription();
		String thirdCall = product.getDescription();

		assertThat(firstCall).isEqualTo(description);
		assertThat(secondCall).isEqualTo(description);
		assertThat(thirdCall).isEqualTo(description);
		assertThat(firstCall).isSameAs(secondCall);
		assertThat(secondCall).isSameAs(thirdCall);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWithSingleCharacter - Should return single character description")
	void getDescriptionWithSingleCharacter() {

		String singleChar = "A";
		product.setDescription(singleChar);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).hasSize(1);
		assertThat(actualDescription).isEqualTo("A");
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@BeforeEach
	void setUp() {
		product = new Product();
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPricePositiveValue - Should return positive price value")
	void getPricePositiveValue() {

		product.setPrice(100.50);

		double actualPrice = product.getPrice();

		assertEquals(100.50, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPriceZeroValue - Should return zero when price is set to zero")
	void getPriceZeroValue() {

		product.setPrice(0.0);

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("getPriceNegativeValue - Should return negative value when negative price is set")
	void getPriceNegativeValue() {

		product.setPrice(-50.75);

		double actualPrice = product.getPrice();

		assertEquals(-50.75, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPriceDecimalPrecision - Should return precise decimal value")
	void getPriceDecimalPrecision() {

		product.setPrice(99.999999);

		double actualPrice = product.getPrice();

		assertEquals(99.999999, actualPrice, 0.000001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPriceMaxDoubleValue - Should handle maximum double value")
	void getPriceMaxDoubleValue() {

		product.setPrice(Double.MAX_VALUE);

		double actualPrice = product.getPrice();

		assertEquals(Double.MAX_VALUE, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPriceMinPositiveValue - Should handle minimum positive double value")
	void getPriceMinPositiveValue() {

		product.setPrice(Double.MIN_VALUE);

		double actualPrice = product.getPrice();

		assertEquals(Double.MIN_VALUE, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPriceDefaultValue - Should return 0.0 as default value without initialization")
	void getPriceDefaultValue() {

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPriceAfterMultipleUpdates - Should return latest updated price value")
	void getPriceAfterMultipleUpdates() {

		product.setPrice(10.0);
		product.setPrice(20.0);
		product.setPrice(30.0);

		double actualPrice = product.getPrice();

		assertEquals(30.0, actualPrice);
	}

}