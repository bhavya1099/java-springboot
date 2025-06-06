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
	@Tag("valid")
	@DisplayName("getIdAfterUpdate - Should return updated ID after modification")
	void getIdAfterUpdate() {

		Long initialId = 100L;
		Long updatedId = 200L;
		product.setId(initialId);

		product.setId(updatedId);
		Long actualId = product.getId();

		assertEquals(updatedId, actualId);
		assertNotEquals(initialId, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithMaxLongValue - Should handle Long.MAX_VALUE correctly")
	void getIdWithMaxLongValue() {

		Long maxValue = Long.MAX_VALUE;
		product.setId(maxValue);

		Long actualId = product.getId();

		assertEquals(maxValue, actualId);
		assertEquals(Long.MAX_VALUE, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithMinLongValue - Should handle Long.MIN_VALUE correctly")
	void getIdWithMinLongValue() {

		Long minValue = Long.MIN_VALUE;
		product.setId(minValue);

		Long actualId = product.getId();

		assertEquals(minValue, actualId);
		assertEquals(Long.MIN_VALUE, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithZeroValue - Should return zero when ID is set to 0L")
	void getIdWithZeroValue() {

		Long zeroValue = 0L;
		product.setId(zeroValue);

		Long actualId = product.getId();

		assertEquals(zeroValue, actualId);
		assertEquals(0L, actualId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdWithNegativeValue - Should return negative values correctly")
	void getIdWithNegativeValue() {

		Long negativeValue = -100L;
		product.setId(negativeValue);

		Long actualId = product.getId();

		assertEquals(negativeValue, actualId);
		assertEquals(-100L, actualId);
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
	@DisplayName("getNameWhenNameIsSet - Should return correct name when name is set")
	void getNameWhenNameIsSet() {

		String expectedName = "Test Product";
		product.setName(expectedName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getNameWhenNameIsNull - Should return null when name is not set")
	void getNameWhenNameIsNull() {

		String actualName = product.getName();

		assertThat(actualName).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getNameWhenNameIsEmpty - Should return empty string when name is set to empty")
	void getNameWhenNameIsEmpty() {

		product.setName("");

		String actualName = product.getName();

		assertThat(actualName).isEmpty();
		assertThat(actualName).isEqualTo("");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getNameWithSpecialCharacters - Should return name with special characters correctly")
	void getNameWithSpecialCharacters() {

		String specialName = "@#$% מוצר 123";
		product.setName(specialName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(specialName);
		assertThat(actualName).contains("@", "#", "$", "%", "123");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getNameAfterUpdate - Should return updated name after change")
	void getNameAfterUpdate() {

		String initialName = "Initial Product";
		String updatedName = "Updated Product";
		product.setName(initialName);

		product.setName(updatedName);
		String actualName = product.getName();

		assertThat(actualName).isEqualTo(updatedName);
		assertThat(actualName).isNotEqualTo(initialName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getNameWithVeryLongString - Should return very long name correctly")
	void getNameWithVeryLongString() {

		StringBuilder longNameBuilder = new StringBuilder();
		for (int i = 0; i < 500; i++) {
			longNameBuilder.append("a");
		}
		String longName = longNameBuilder.toString();
		product.setName(longName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(longName);
		assertThat(actualName).hasSize(500);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should handle name with leading and trailing spaces")
	void getNameWithSpaces() {

		String nameWithSpaces = "  Product Name  ";
		product.setName(nameWithSpaces);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(nameWithSpaces);
		assertThat(actualName).startsWith("  ");
		assertThat(actualName).endsWith("  ");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should handle name with unicode characters")
	void getNameWithUnicodeCharacters() {

		String unicodeName = "Product™ © ® € £ ¥ 中文 العربية हिन्दी";
		product.setName(unicodeName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(unicodeName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should handle name with line breaks and tabs")
	void getNameWithLineBreaksAndTabs() {

		String nameWithBreaks = "Product\nName\tWith\rBreaks";
		product.setName(nameWithBreaks);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(nameWithBreaks);
		assertThat(actualName).contains("\n", "\t", "\r");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should maintain name consistency across multiple calls")
	void getNameConsistency() {

		String expectedName = "Consistent Product";
		product.setName(expectedName);

		String firstCall = product.getName();
		String secondCall = product.getName();
		String thirdCall = product.getName();

		assertThat(firstCall).isEqualTo(expectedName);
		assertThat(secondCall).isEqualTo(expectedName);
		assertThat(thirdCall).isEqualTo(expectedName);
		assertThat(firstCall).isSameAs(secondCall);
		assertThat(secondCall).isSameAs(thirdCall);
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

		String expectedDescription = "This is a test product description";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWhenNull - Should return null when description is not set")
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
	@DisplayName("getDescriptionWhenEmpty - Should return empty string when description is set as empty")
	void getDescriptionWhenEmpty() {

		product.setDescription("");

		String actualDescription = product.getDescription();

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

		StringBuilder longDescription = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			longDescription.append("a");
		}
		String expectedDescription = longDescription.toString();
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).hasSize(1000);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionWithSpecialCharacters - Should return description with special characters unchanged")
	void getDescriptionWithSpecialCharacters() {

		String expectedDescription = "Special chars: @#$%^&*()_+-=[]{}|;':\",./<>?";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionAfterUpdate - Should return updated description after modification")
	void getDescriptionAfterUpdate() {

		String initialDescription = "Initial description";
		String updatedDescription = "Updated description";
		product.setDescription(initialDescription);
		product.setDescription(updatedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(updatedDescription);
		assertThat(actualDescription).isNotEqualTo(initialDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionWithNewLines - Should return description with newline characters preserved")
	void getDescriptionWithNewLines() {

		String expectedDescription = "Line 1\nLine 2\nLine 3";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).contains("\n");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWithLeadingTrailingSpaces - Should return description with leading and trailing spaces preserved")
	void getDescriptionWithLeadingTrailingSpaces() {

		String expectedDescription = "   Description with spaces   ";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).startsWith("   ");
		assertThat(actualDescription).endsWith("   ");
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
	@DisplayName("getPriceWithValidValue - Should return correct price when valid value is set")
	void getPriceWithValidValue() {

		double expectedPrice = 25.99;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPriceWithZeroValue - Should return 0.0 when price is set to zero")
	void getPriceWithZeroValue() {

		product.setPrice(0.0);

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("getPriceWithNegativeValue - Should return negative value when negative price is set")
	void getPriceWithNegativeValue() {

		product.setPrice(-10.5);

		double actualPrice = product.getPrice();

		assertEquals(-10.5, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPriceWithDecimalPrecision - Should return exact decimal value with precision")
	void getPriceWithDecimalPrecision() {

		product.setPrice(99.99);

		double actualPrice = product.getPrice();

		assertEquals(99.99, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPriceWithVeryHighValue - Should return very high value without data loss")
	void getPriceWithVeryHighValue() {

		product.setPrice(1000000.50);

		double actualPrice = product.getPrice();

		assertEquals(1000000.50, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPriceDefaultValue - Should return 0.0 as default when price is not set")
	void getPriceDefaultValue() {

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPriceAfterMultipleUpdates - Should return latest price after multiple updates")
	void getPriceAfterMultipleUpdates() {

		product.setPrice(50.0);
		product.setPrice(75.0);
		product.setPrice(100.0);

		double actualPrice = product.getPrice();

		assertEquals(100.0, actualPrice, 0.001);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPriceWithVerySmallValue - Should return very small value close to zero accurately")
	void getPriceWithVerySmallValue() {

		product.setPrice(0.001);

		double actualPrice = product.getPrice();

		assertEquals(0.001, actualPrice, 0.0001);
	}

}