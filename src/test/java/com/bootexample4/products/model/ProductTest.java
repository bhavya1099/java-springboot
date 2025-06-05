package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

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
	@DisplayName("getId returns correct value when id is set")
	void getIdWhenIdIsSet() {

		Long expectedId = 123L;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertEquals(expectedId, actualId);
		assertThat(actualId).isEqualTo(expectedId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getId returns null when id is not set")
	void getIdWhenIdIsNull() {

		Long actualId = product.getId();

		assertNull(actualId);
		assertThat(actualId).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getId returns updated value after id update")
	void getIdAfterUpdate() {

		Long initialId = 100L;
		Long updatedId = 200L;
		product.setId(initialId);

		product.setId(updatedId);
		Long actualId = product.getId();

		assertEquals(updatedId, actualId);
		assertThat(actualId).isEqualTo(updatedId);
		assertThat(actualId).isNotEqualTo(initialId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getId handles maximum Long value correctly")
	void getIdWithMaxLongValue() {

		Long maxValue = Long.MAX_VALUE;
		product.setId(maxValue);

		Long actualId = product.getId();

		assertEquals(maxValue, actualId);
		assertThat(actualId).isEqualTo(Long.MAX_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getId handles minimum Long value correctly")
	void getIdWithMinLongValue() {

		Long minValue = Long.MIN_VALUE;
		product.setId(minValue);

		Long actualId = product.getId();

		assertEquals(minValue, actualId);
		assertThat(actualId).isEqualTo(Long.MIN_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getId returns zero value correctly")
	void getIdWithZeroValue() {

		Long zeroValue = 0L;
		product.setId(zeroValue);

		Long actualId = product.getId();

		assertEquals(zeroValue, actualId);
		assertThat(actualId).isEqualTo(0L);
		assertThat(actualId).isZero();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getId returns negative value correctly")
	void getIdWithNegativeValue() {

		Long negativeValue = -100L;
		product.setId(negativeValue);

		Long actualId = product.getId();

		assertEquals(negativeValue, actualId);
		assertThat(actualId).isEqualTo(-100L);
		assertThat(actualId).isNegative();
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
	@DisplayName("getName returns correct name when name is set")
	void getNameWhenNameIsSet() {

		String expectedName = "Test Product";
		product.setName(expectedName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(expectedName);
		assertThat(actualName).isNotNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getName returns null when name is not set")
	void getNameWhenNameIsNull() {

		String actualName = product.getName();

		assertThat(actualName).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getName returns empty string when name is set to empty")
	void getNameWhenNameIsEmpty() {

		String emptyName = "";
		product.setName(emptyName);

		String actualName = product.getName();

		assertThat(actualName).isEmpty();
		assertThat(actualName).isEqualTo("");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getName returns name with special characters correctly")
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
	@DisplayName("getName returns updated name after modification")
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
	@DisplayName("getName returns very long string correctly")
	void getNameWithVeryLongString() {

		String longName = "A".repeat(500);
		product.setName(longName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(longName);
		assertThat(actualName).hasSize(500);
		assertThat(actualName).startsWith("AAAA");
		assertThat(actualName).endsWith("AAAA");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@ParameterizedTest
	@MethodSource("provideNameTestCases")
	@Tag("valid")
	@DisplayName("getName returns correct value for various name inputs")
	void getNameParameterizedTest(String inputName, String expectedName) {

		product.setName(inputName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */private static Stream<Arguments> provideNameTestCases() {
		return Stream.of(Arguments.of("Simple Product", "Simple Product"), Arguments.of("Product-123", "Product-123"),
				Arguments.of("Product_with_underscore", "Product_with_underscore"),
				Arguments.of("Product with spaces", "Product with spaces"), Arguments.of("123456789", "123456789"),
				Arguments.of("Product™", "Product™"), Arguments.of("Ñoño Product", "Ñoño Product"),
				Arguments.of("产品", "产品"), Arguments.of("🎁 Gift Product", "🎁 Gift Product"));
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getName maintains consistency across multiple calls")
	void getNameConsistencyTest() {

		String productName = "Consistent Product";
		product.setName(productName);

		String firstCall = product.getName();
		String secondCall = product.getName();
		String thirdCall = product.getName();

		assertThat(firstCall).isEqualTo(productName);
		assertThat(secondCall).isEqualTo(productName);
		assertThat(thirdCall).isEqualTo(productName);
		assertThat(firstCall).isSameAs(secondCall);
		assertThat(secondCall).isSameAs(thirdCall);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getName handles whitespace-only names")
	void getNameWithWhitespaceOnly() {

		String whitespaceName = "   \t\n\r   ";
		product.setName(whitespaceName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(whitespaceName);
		assertThat(actualName.trim()).isEmpty();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getName preserves leading and trailing spaces")
	void getNamePreservesSpaces() {

		String nameWithSpaces = "  Product Name  ";
		product.setName(nameWithSpaces);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(nameWithSpaces);
		assertThat(actualName).startsWith("  ");
		assertThat(actualName).endsWith("  ");
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

		String expectedDescription = "This is a high-quality product";
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
	@Tag("valid")
	@DisplayName("getDescriptionWithLongText - Should return long description without truncation")
	void getDescriptionWithLongText() {

		StringBuilder longDescription = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			longDescription.append("This is a very long description text. ");
		}
		String expectedDescription = longDescription.toString();
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription.length()).isEqualTo(expectedDescription.length());
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionWithSpecialCharacters - Should return description with special characters unchanged")
	void getDescriptionWithSpecialCharacters() {

		String specialCharsDescription = "Product @#$%^&* with special chars! <>&\"'";
		product.setDescription(specialCharsDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(specialCharsDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescriptionAfterUpdate - Should return updated description after change")
	void getDescriptionAfterUpdate() {

		String initialDescription = "Initial product description";
		String updatedDescription = "Updated product description with new features";
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

		String multilineDescription = "First line\nSecond line\nThird line\n\nFifth line after empty line";
		product.setDescription(multilineDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(multilineDescription);
		assertThat(actualDescription).contains("\n");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescriptionWithLeadingTrailingSpaces - Should return description with spaces preserved")
	void getDescriptionWithLeadingTrailingSpaces() {

		String spacedDescription = "   Product with leading and trailing spaces   ";
		product.setDescription(spacedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(spacedDescription);
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
	@DisplayName("Get price with valid value")
	void getPriceWithValidValue() {

		double expectedPrice = 25.50;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Get price with zero value")
	void getPriceWithZeroValue() {

		double expectedPrice = 0.0;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("Get price with negative value")
	void getPriceWithNegativeValue() {

		double expectedPrice = -10.5;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Get price with decimal precision")
	void getPriceWithDecimalPrecision() {

		double expectedPrice = 99.99;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Get price with very high value")
	void getPriceWithVeryHighValue() {

		double expectedPrice = 1000000.50;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Get price default value")
	void getPriceDefaultValue() {

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Get price after multiple updates")
	void getPriceAfterMultipleUpdates() {

		product.setPrice(50.0);
		product.setPrice(75.0);
		product.setPrice(100.0);

		double actualPrice = product.getPrice();

		assertEquals(100.0, actualPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Get price with very small value")
	void getPriceWithVerySmallValue() {

		double expectedPrice = 0.001;
		product.setPrice(expectedPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
	}

}