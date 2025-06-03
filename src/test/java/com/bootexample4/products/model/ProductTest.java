package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	@DisplayName("בדיקת החזרת מזהה כאשר הוא מוגדר")
	void bedikatHachzaratMeZaheKasheHuMugdar() {

		product.setId(123L);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(123L);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("בדיקת החזרת מזהה כאשר הוא null")
	void bedikatHachzaratMeZaheKasheHuNull() {

		Long actualId = product.getId();

		assertThat(actualId).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("בדיקת החזרת מזהה אחרי עדכון")
	void bedikatHachzaratMeZaheAchareiIdkun() {

		product.setId(100L);
		product.setId(200L);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(200L);
		assertThat(actualId).isNotEqualTo(100L);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("בדיקת החזרת מזהה עם ערך אפס")
	void bedikatHachzaratMeZaheImErechEfes() {

		product.setId(0L);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(0L);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("invalid")
	@DisplayName("בדיקת החזרת מזהה עם ערך שלילי")
	void bedikatHachzaratMeZaheImErechShlili() {

		product.setId(-50L);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(-50L);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("בדיקת החזרת מזהה עם ערך מקסימלי של Long")
	void bedikatHachzaratMeZaheImErechMaksimali() {

		product.setId(Long.MAX_VALUE);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(Long.MAX_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("בדיקת עקביות של החזרת מזהה בקריאות מרובות")
	void bedikatIkviyutShellHachzaratMeZaheBikriotMerubot() {

		product.setId(999L);

		Long firstCall = product.getId();
		Long secondCall = product.getId();
		Long thirdCall = product.getId();

		assertThat(firstCall).isEqualTo(999L);
		assertThat(secondCall).isEqualTo(999L);
		assertThat(thirdCall).isEqualTo(999L);
		assertThat(firstCall).isEqualTo(secondCall).isEqualTo(thirdCall);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@ParameterizedTest
	@Tag("valid")
	@DisplayName("בדיקת החזרת מזהים שונים")
	@MethodSource("provideIdValues")
	void testGetIdWithDifferentValues(Long inputId, Long expectedId) {

		product.setId(inputId);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(expectedId);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */private static Stream<Arguments> provideIdValues() {
		return Stream.of(Arguments.of(1L, 1L), Arguments.of(100L, 100L), Arguments.of(9999L, 9999L),
				Arguments.of(Long.MIN_VALUE, Long.MIN_VALUE), Arguments.of(null, null));
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("בדיקת החזרת מזהה לאחר יצירת אובייקט עם כל השדות")
	void testGetIdWithFullyPopulatedProduct() {

		product.setId(456L);
		product.setName("Test Product");
		product.setDescription("Test Description");
		product.setPrice(99.99);

		Long actualId = product.getId();

		assertThat(actualId).isEqualTo(456L);
		assertThat(product.getName()).isNotNull();
		assertThat(product.getDescription()).isNotNull();
		assertThat(product.getPrice()).isGreaterThan(0);
	}

	/*
	 * ROOST_METHOD_HASH=getId_7023725436 ROOST_METHOD_SIG_HASH=getId_ba349b1eff
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("בדיקת החזרת מזהה עם ערכי גבול נוספים")
	void testGetIdWithAdditionalBoundaryValues() {

		product.setId(1L);
		assertThat(product.getId()).isEqualTo(1L);

		product.setId(-1L);
		assertThat(product.getId()).isEqualTo(-1L);

		product.setId(Long.MIN_VALUE);
		assertThat(product.getId()).isEqualTo(Long.MIN_VALUE);
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
	@DisplayName("hachzaratShemRagil - בדיקת החזרת שם רגיל")
	void testGetName_ReturnsRegularName() {

		String expectedName = "מוצר רגיל";
		product.setName(expectedName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("hachzaratErechNull - בדיקת החזרת ערך null")
	void testGetName_ReturnsNullWhenNotSet() {

		String actualName = product.getName();

		assertThat(actualName).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("hachzaratMachrozetReika - בדיקת החזרת מחרוזת ריקה")
	void testGetName_ReturnsEmptyString() {

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
	@DisplayName("hachzaratShemImRevachim - בדיקת החזרת שם עם רווחים")
	void testGetName_ReturnsNameWithSpaces() {

		String nameWithSpaces = " מוצר חדש ";
		product.setName(nameWithSpaces);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(nameWithSpaces);
		assertThat(actualName).startsWith(" ");
		assertThat(actualName).endsWith(" ");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("hachzaratShemArochMeod - בדיקת החזרת שם ארוך מאוד")
	void testGetName_ReturnsVeryLongName() {

		StringBuilder longNameBuilder = new StringBuilder();
		for (int i = 0; i < 1001; i++) {
			longNameBuilder.append("א");
		}
		String longName = longNameBuilder.toString();
		product.setName(longName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(longName);
		assertThat(actualName.length()).isGreaterThan(1000);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("hachzaratShemImTavimMeyuchadim - בדיקת החזרת שם עם תווים מיוחדים")
	void testGetName_ReturnsNameWithSpecialCharacters() {

		String nameWithSpecialChars = "מוצר@#$%123";
		product.setName(nameWithSpecialChars);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(nameWithSpecialChars);
		assertThat(actualName).contains("@", "#", "$", "%");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("idkunVehachzaratShem - בדיקת עדכון והחזרת שם")
	void testGetName_ReturnsUpdatedName() {

		product.setName("שם ישן");
		product.setName("שם חדש");

		String actualName = product.getName();

		assertThat(actualName).isEqualTo("שם חדש");
		assertThat(actualName).isNotEqualTo("שם ישן");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("hachzaratShemMisparimBilvad - בדיקת החזרת שם עם מספרים בלבד")
	void testGetName_ReturnsNumericOnlyName() {

		String numericName = "123456789";
		product.setName(numericName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(numericName);
		assertThat(actualName).matches("\\d+");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("hachzaratShemImTaveiUnicode - בדיקת החזרת שם עם תווי Unicode")
	void testGetName_ReturnsNameWithUnicodeCharacters() {

		String unicodeName = "מוצר 😊 🌟";
		product.setName(unicodeName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(unicodeName);
		assertThat(actualName).contains("😊", "🌟");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("kriotMerubot - בדיקת קריאות מרובות")
	void testGetName_MultipleCallsReturnSameValue() {

		String constantName = "מוצר קבוע";
		product.setName(constantName);

		String firstCall = product.getName();
		String secondCall = product.getName();
		String thirdCall = product.getName();

		assertThat(firstCall).isEqualTo(constantName);
		assertThat(secondCall).isEqualTo(constantName);
		assertThat(thirdCall).isEqualTo(constantName);
		assertThat(firstCall).isSameAs(secondCall);
		assertThat(secondCall).isSameAs(thirdCall);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@ParameterizedTest
	@MethodSource("provideVariousNames")
	@Tag("valid")
	@DisplayName("Table-driven test for various name scenarios")
	void testGetName_VariousScenarios(String inputName, String expectedName) {

		product.setName(inputName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(expectedName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */private static Stream<Arguments> provideVariousNames() {
		return Stream.of(Arguments.of("Simple Product", "Simple Product"), Arguments.of("Product-123", "Product-123"),
				Arguments.of("מוצר בעברית", "מוצר בעברית"),
				Arguments.of("Product_with_underscore", "Product_with_underscore"),
				Arguments.of("Product.with.dots", "Product.with.dots"),
				Arguments.of("Product/with/slashes", "Product/with/slashes"),
				Arguments.of("Product\\with\\backslashes", "Product\\with\\backslashes"),
				Arguments.of("Product\nwith\nnewlines", "Product\nwith\nnewlines"),
				Arguments.of("Product\twith\ttabs", "Product\twith\ttabs"),
				Arguments.of("UPPERCASE PRODUCT", "UPPERCASE PRODUCT"),
				Arguments.of("lowercase product", "lowercase product"),
				Arguments.of("MiXeD CaSe PrOdUcT", "MiXeD CaSe PrOdUcT"));
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Test getName with single character name")
	void testGetName_SingleCharacter() {

		product.setName("A");

		String actualName = product.getName();

		assertThat(actualName).isEqualTo("A");
		assertThat(actualName).hasSize(1);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Test getName with name containing only whitespace characters")
	void testGetName_OnlyWhitespace() {

		String whitespaceOnly = "   \t\n\r   ";
		product.setName(whitespaceOnly);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(whitespaceOnly);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Test getName with HTML tags in name")
	void testGetName_WithHtmlTags() {

		String htmlName = "<b>Bold Product</b>";
		product.setName(htmlName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(htmlName);
		assertThat(actualName).contains("<b>", "</b>");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Test getName with SQL injection attempt")
	void testGetName_SqlInjectionAttempt() {

		String sqlInjection = "Product'; DROP TABLE products; --";
		product.setName(sqlInjection);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(sqlInjection);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Test getName with JSON string")
	void testGetName_JsonString() {

		String jsonName = "{\"name\":\"Product\",\"type\":\"electronics\"}";
		product.setName(jsonName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(jsonName);
		assertThat(actualName).contains("{", "}", "\"");
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Test getName with XML string")
	void testGetName_XmlString() {

		String xmlName = "<product><name>Test Product</name></product>";
		product.setName(xmlName);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(xmlName);
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Test getName immediately after object creation")
	void testGetName_ImmediatelyAfterCreation() {

		Product newProduct = new Product();

		String actualName = newProduct.getName();

		assertThat(actualName).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getName_3a12ffc596 ROOST_METHOD_SIG_HASH=getName_8400ac6fb7
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Test getName with name containing quotes")
	void testGetName_WithQuotes() {

		String nameWithQuotes = "Product \"Premium\" Edition";
		product.setName(nameWithQuotes);

		String actualName = product.getName();

		assertThat(actualName).isEqualTo(nameWithQuotes);
		assertThat(actualName).contains("\"");
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
	@DisplayName("hachzaratTeurRagil - בדיקת החזרת תיאור רגיל")
	void testGetDescription_WithRegularDescription_ReturnsCorrectDescription() {

		String expectedDescription = "This is a high-quality product with excellent features";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).isNotNull();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("hachzaratTeurReik - בדיקת החזרת תיאור ריק")
	void testGetDescription_WithEmptyDescription_ReturnsEmptyString() {

		product.setDescription("");

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEmpty();
		assertThat(actualDescription).isNotNull();
		assertThat(actualDescription).isEqualTo("");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("hachzaratNullBliHagdara - בדיקת החזרת null כאשר לא הוגדר תיאור")
	void testGetDescription_WithoutSettingDescription_ReturnsNull() {

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isNull();
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("hachzaratTeurArochMeod - בדיקת החזרת תיאור ארוך מאוד")
	void testGetDescription_WithVeryLongDescription_ReturnsFullDescription() {

		StringBuilder longDescriptionBuilder = new StringBuilder();
		for (int i = 0; i < 150; i++) {
			longDescriptionBuilder
				.append("This is a very long description that contains many details about the product. ");
		}
		String expectedDescription = longDescriptionBuilder.toString();
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription.length()).isGreaterThan(1000);
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("hachzaratTeurImTavimMeyuchadim - בדיקת החזרת תיאור עם תווים מיוחדים")
	void testGetDescription_WithSpecialCharacters_ReturnsDescriptionWithAllCharacters() {

		String expectedDescription = "Special chars: @#$%^&*()_+-=[]{}|;':\",./<>?\n\tNew line and tab\nAnother line";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).contains("@#$%^&*");
		assertThat(actualDescription).contains("\n");
		assertThat(actualDescription).contains("\t");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("idkunVehachzaratTeurMeudkan - בדיקת עדכון והחזרת תיאור מעודכן")
	void testGetDescription_AfterUpdate_ReturnsUpdatedDescription() {

		String initialDescription = "Initial product description";
		String updatedDescription = "Updated product description with new features";
		product.setDescription(initialDescription);

		assertThat(product.getDescription()).isEqualTo(initialDescription);

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
	@Tag("boundary")
	@DisplayName("hachzaratTeurImRevachimBitchilaBesof - בדיקת החזרת תיאור עם רווחים בתחילה ובסוף")
	void testGetDescription_WithLeadingAndTrailingSpaces_ReturnsDescriptionWithSpaces() {

		String expectedDescription = "   Product description with spaces   ";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).startsWith("   ");
		assertThat(actualDescription).endsWith("   ");
		assertThat(actualDescription.trim()).isEqualTo("Product description with spaces");
	}

	/*
	 * ROOST_METHOD_HASH=getDescription_791d670f82
	 * ROOST_METHOD_SIG_HASH=getDescription_b1844ea396
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("hachzaratTeurBisfotShonot - בדיקת החזרת תיאור בשפות שונות")
	void testGetDescription_WithMultipleLanguages_ReturnsDescriptionInAllLanguages() {

		String expectedDescription = "English description | תיאור בעברית | وصف بالعربية | 中文描述";
		product.setDescription(expectedDescription);

		String actualDescription = product.getDescription();

		assertThat(actualDescription).isEqualTo(expectedDescription);
		assertThat(actualDescription).contains("English description");
		assertThat(actualDescription).contains("תיאור בעברית");
		assertThat(actualDescription).contains("وصف بالعربية");
		assertThat(actualDescription).contains("中文描述");
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
	@DisplayName("hachzaratMechirRagil - בדיקה שהמתודה getPrice מחזירה את המחיר הנכון כאשר נקבע מחיר חיובי רגיל למוצר")
	void hachzaratMechirRagil() {

		product.setPrice(99.99);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(99.99);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should return zero when price is set to zero")
	void shouldReturnZeroWhenPriceIsZero() {

		product.setPrice(0.0);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should return negative price when negative price is set")
	void shouldReturnNegativePriceWhenNegativePriceIsSet() {

		product.setPrice(-50.75);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(-50.75);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Should return maximum double value when set to max")
	void shouldReturnMaxDoubleValue() {

		product.setPrice(Double.MAX_VALUE);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(Double.MAX_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("boundary")
	@DisplayName("Should return minimum double value when set to min")
	void shouldReturnMinDoubleValue() {

		product.setPrice(Double.MIN_VALUE);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(Double.MIN_VALUE);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@ParameterizedTest
	@CsvSource({ "1.99, 1.99", "10.50, 10.50", "999.99, 999.99", "0.01, 0.01", "1000000.00, 1000000.00" })
	@Tag("valid")
	@DisplayName("Should return correct price for various valid price values")
	void shouldReturnCorrectPriceForVariousValues(double inputPrice, double expectedPrice) {

		product.setPrice(inputPrice);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(expectedPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should return default price value when no price is set")
	void shouldReturnDefaultPriceWhenNoPriceIsSet() {

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(0.0);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should maintain precision for decimal prices")
	void shouldMaintainPrecisionForDecimalPrices() {

		product.setPrice(123.456789);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(123.456789);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@ParameterizedTest
	@ValueSource(doubles = { 0.001, 0.0001, 0.00001 })
	@Tag("boundary")
	@DisplayName("Should handle very small positive prices")
	void shouldHandleVerySmallPositivePrices(double smallPrice) {

		product.setPrice(smallPrice);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(smallPrice);
	}

	/*
	 * ROOST_METHOD_HASH=getPrice_b54117587b ROOST_METHOD_SIG_HASH=getPrice_d2cb73a47d
	 *
	 */@Test
	@Tag("valid")
	@DisplayName("Should return updated price after multiple price changes")
	void shouldReturnUpdatedPriceAfterMultipleChanges() {

		product.setPrice(10.00);
		product.setPrice(20.00);
		product.setPrice(30.00);

		double actualPrice = product.getPrice();

		assertThat(actualPrice).isEqualTo(30.00);
	}

}