package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.CsvSource;

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
	@DisplayName("getIdWhenIdIsSet - בדיקת החזרת מזהה כאשר הוא מוגדר")
	void getIdWhenIdIsSet() {

		Long expectedId = 123L;
		product.setId(expectedId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(expectedId);
		assertThat(actualId).isNotNull();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdWhenIdIsNull - בדיקת החזרת null כאשר המזהה לא מוגדר")
	void getIdWhenIdIsNull() {

		Long actualId = product.getId();

		assertThat(actualId).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithZeroValue - בדיקת החזרת מזהה עם ערך אפס")
	void getIdWithZeroValue() {

		Long zeroId = 0L;
		product.setId(zeroId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(0L);
		assertThat(actualId).isNotNull();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("getIdWithNegativeValue - בדיקת החזרת מזהה עם ערך שלילי")
	void getIdWithNegativeValue() {

		Long negativeId = -100L;
		product.setId(negativeId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(-100L);
		assertThat(actualId).isNegative();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithMaxLongValue - בדיקת החזרת מזהה עם ערך מקסימלי של Long")
	void getIdWithMaxLongValue() {

		Long maxId = Long.MAX_VALUE;
		product.setId(maxId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(Long.MAX_VALUE);
		assertThat(actualId).isPositive();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdConsistencyAfterMultipleChanges - בדיקת עקביות לאחר שינויים מרובים")
	void getIdConsistencyAfterMultipleChanges() {

		Long firstId = 10L;
		product.setId(firstId);
		assertThat(product.getId()).isEqualTo(10L);

		Long secondId = 20L;
		product.setId(secondId);
		assertThat(product.getId()).isEqualTo(20L);

		Long thirdId = 30L;
		product.setId(thirdId);
		assertThat(product.getId()).isEqualTo(30L);

		assertThat(product.getId()).isEqualTo(thirdId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getIdWithMinLongValue - בדיקת החזרת מזהה עם ערך מינימלי של Long")
	void getIdWithMinLongValue() {

		Long minId = Long.MIN_VALUE;
		product.setId(minId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(Long.MIN_VALUE);
		assertThat(actualId).isNegative();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdMultipleCallsConsistency - בדיקת עקביות בקריאות מרובות")
	void getIdMultipleCallsConsistency() {

		Long expectedId = 999L;
		product.setId(expectedId);

		for (int i = 0; i < 5; i++) {
			Long actualId = product.getId();
			assertThat(actualId).isEqualTo(expectedId);
		}
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdWithTypicalDatabaseId - בדיקת מזהה טיפוסי ממסד נתונים")
	void getIdWithTypicalDatabaseId() {

		Long typicalId = 1000000L;
		product.setId(typicalId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(1000000L);
		assertThat(actualId).isPositive();
		assertThat(actualId).isGreaterThan(0L);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getIdAfterSettingToNullFromValue - בדיקת החזרת null לאחר איפוס")
	void getIdAfterSettingToNullFromValue() {

		product.setId(50L);
		assertThat(product.getId()).isEqualTo(50L);
		product.setId(null);

		Long actualId = product.getId();

		assertThat(actualId).isNull();
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

		assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	void getNameWhenNameIsNull() {

		String actualName = product.getName();

		assertThat(actualName).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	void getNameWhenNameIsEmptyString() {

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
	void getNameAfterNameChange() {

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
	@Tag("valid")
	void getNameWithSpecialCharacters() {

		String specialName = "Product @#$% & Special !@#$%^&*() Characters";
		product.setName(specialName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(specialName);
		assertThat(actualName).contains("@", "#", "$", "%", "&", "!");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	void getNameWithVeryLongString() {

		StringBuilder longNameBuilder = new StringBuilder();
		for (int i = 0; i < 500; i++) {
			longNameBuilder.append("LongProductName");
		}
		String longName = longNameBuilder.toString();
		product.setName(longName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(longName);
		assertThat(actualName.length()).isEqualTo(longName.length());
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void getNameWithUnicodeCharacters() {

		String unicodeName = "מוצר בעברית 产品中文 منتج عربي Ñoño émojis 😀🎉";
		product.setName(unicodeName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(unicodeName);
		assertThat(actualName).contains("מוצר", "产品", "منتج", "Ñ", "😀");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	void multipleCallsToGetName() {

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
	@DisplayName("getDescriptionWhenDescriptionIsNotNull - בדיקה שהמתודה getDescription מחזירה את התיאור הנכון כאשר השדה description מכיל ערך תקין")
	void getDescriptionWhenDescriptionIsNotNull() {

		String expectedDescription = "High-quality wireless headphones with noise cancellation";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertEquals(expectedDescription, actualDescription);
		assertNotNull(actualDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescription returns null when description is not set")
	void getDescriptionWhenDescriptionIsNull() {

		String actualDescription = product.getDescription();

		assertNull(actualDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescription returns empty string when description is set to empty")
	void getDescriptionWhenDescriptionIsEmpty() {

		String expectedDescription = "";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertEquals(expectedDescription, actualDescription);
		assertThat(actualDescription).isEmpty();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@ParameterizedTest
	@Tag("valid")
	@DisplayName("getDescription returns correct value for various descriptions")
	@MethodSource("provideDescriptions")
	void getDescriptionWithVariousInputs(String description, String expected) {

		product.setDescription(description);

		String actualDescription = product.getDescription();

		assertEquals(expected, actualDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */private static Stream<Arguments> provideDescriptions() {
		return Stream.of(Arguments.of("Simple product description", "Simple product description"),
				Arguments.of("Description with special characters: @#$%^&*()",
						"Description with special characters: @#$%^&*()"),
				Arguments.of("Multi-line\ndescription\nwith breaks", "Multi-line\ndescription\nwith breaks"),
				Arguments.of("Description with numbers 12345", "Description with numbers 12345"),
				Arguments.of("   Description with leading and trailing spaces   ",
						"   Description with leading and trailing spaces   "));
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getDescription handles very long description")
	void getDescriptionWithVeryLongText() {

		String longDescription = "A".repeat(1000);
		product.setDescription(longDescription);

		String actualDescription = product.getDescription();

		assertEquals(longDescription, actualDescription);
		assertEquals(1000, actualDescription.length());
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescription returns description with unicode characters")
	void getDescriptionWithUnicodeCharacters() {

		String unicodeDescription = "Product description with unicode: 你好世界 🌍 مرحبا بالعالم";
		product.setDescription(unicodeDescription);

		String actualDescription = product.getDescription();

		assertEquals(unicodeDescription, actualDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescription maintains consistency after multiple calls")
	void getDescriptionConsistencyCheck() {

		String expectedDescription = "Consistent description";
		product.setDescription(expectedDescription);

		for (int i = 0; i < 5; i++) {
			String actualDescription = product.getDescription();
			assertEquals(expectedDescription, actualDescription);
		}
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescription after updating description multiple times")
	void getDescriptionAfterMultipleUpdates() {

		product.setDescription("First description");
		product.setDescription("Second description");
		String finalDescription = "Final description";
		product.setDescription(finalDescription);

		String actualDescription = product.getDescription();

		assertEquals(finalDescription, actualDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@ParameterizedTest
	@Tag("boundary")
	@DisplayName("getDescription with whitespace variations")
	@ValueSource(strings = { " ", "\t", "\n", "\r", "   \t\n\r   " })
	void getDescriptionWithWhitespaceOnly(String whitespaceDescription) {

		product.setDescription(whitespaceDescription);

		String actualDescription = product.getDescription();

		assertEquals(whitespaceDescription, actualDescription);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getDescription returns exact reference to the description field")
	void getDescriptionReturnsExactReference() {

		String description = "Reference test description";
		product.setDescription(description);

		String firstCall = product.getDescription();
		String secondCall = product.getDescription();

		assertThat(firstCall).isSameAs(secondCall);
		assertEquals(description, firstCall);
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
	@DisplayName("getPrice returns correct value when price is set to 99.99")
	void getPriceReturnsCorrectValue() {

		product.setPrice(99.99);

		double actualPrice = product.getPrice();

		assertEquals(99.99, actualPrice);
		assertThat(actualPrice).isEqualTo(99.99);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPrice returns zero for newly created product")
	void getPriceReturnsZeroForNewProduct() {

		double actualPrice = product.getPrice();

		assertEquals(0.0, actualPrice);
		assertThat(actualPrice).isZero();
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@ParameterizedTest
	@Tag("valid")
	@DisplayName("getPrice returns correct values for various prices")
	@CsvSource({ "0.01, 0.01", "1.00, 1.00", "10.50, 10.50", "100.00, 100.00", "999.99, 999.99", "1000.00, 1000.00" })
	void getPriceReturnsCorrectValuesForVariousPrices(double inputPrice, double expectedPrice) {

		product.setPrice(inputPrice);

		double actualPrice = product.getPrice();

		assertEquals(expectedPrice, actualPrice);
		assertThat(actualPrice).isEqualTo(expectedPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPrice returns correct value for maximum double value")
	void getPriceReturnsMaxDoubleValue() {

		product.setPrice(Double.MAX_VALUE);

		double actualPrice = product.getPrice();

		assertEquals(Double.MAX_VALUE, actualPrice);
		assertThat(actualPrice).isEqualTo(Double.MAX_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("getPrice returns correct value for minimum positive double value")
	void getPriceReturnsMinPositiveDoubleValue() {

		product.setPrice(Double.MIN_VALUE);

		double actualPrice = product.getPrice();

		assertEquals(Double.MIN_VALUE, actualPrice);
		assertThat(actualPrice).isEqualTo(Double.MIN_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("getPrice returns negative value when negative price is set")
	void getPriceReturnsNegativeValue() {

		product.setPrice(-50.00);

		double actualPrice = product.getPrice();

		assertEquals(-50.00, actualPrice);
		assertThat(actualPrice).isNegative();
		assertThat(actualPrice).isEqualTo(-50.00);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@ParameterizedTest
	@Tag("boundary")
	@DisplayName("getPrice handles decimal precision correctly")
	@ValueSource(doubles = { 0.001, 0.999, 1.111, 99.999, 123.456789 })
	void getPriceHandlesDecimalPrecision(double price) {

		product.setPrice(price);

		double actualPrice = product.getPrice();

		assertEquals(price, actualPrice, 0.0000001);
		assertThat(actualPrice).isCloseTo(price, org.assertj.core.data.Offset.offset(0.0000001));
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPrice returns updated value after multiple price changes")
	void getPriceReturnsUpdatedValueAfterMultipleChanges() {

		product.setPrice(10.00);
		product.setPrice(20.00);
		product.setPrice(30.00);

		double actualPrice = product.getPrice();

		assertEquals(30.00, actualPrice);
		assertThat(actualPrice).isEqualTo(30.00);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPrice is consistent across multiple calls")
	void getPriceIsConsistentAcrossMultipleCalls() {

		product.setPrice(75.50);

		double firstCall = product.getPrice();
		double secondCall = product.getPrice();
		double thirdCall = product.getPrice();

		assertEquals(firstCall, secondCall);
		assertEquals(secondCall, thirdCall);
		assertThat(firstCall).isEqualTo(75.50);
		assertThat(secondCall).isEqualTo(75.50);
		assertThat(thirdCall).isEqualTo(75.50);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("getPrice returns valid value for product instance")
	void getPriceReturnsValidValueForProductInstance() {

		Product testProduct = new Product();
		testProduct.setPrice(199.99);

		double actualPrice = testProduct.getPrice();

		assertNotNull(testProduct);
		assertEquals(199.99, actualPrice);
		assertThat(actualPrice).isGreaterThanOrEqualTo(0);
		assertThat(actualPrice).isEqualTo(199.99);
	}

}