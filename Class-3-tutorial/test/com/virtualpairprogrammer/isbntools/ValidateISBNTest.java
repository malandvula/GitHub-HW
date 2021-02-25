package com.virtualpairprogrammer.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	@Test
	public void checkAValid10DigitISBN() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkISBN("0140449116");
		assertTrue("First value", result);
		result = validator.checkISBN("0140177396");
		assertTrue("Second value", result);
	}
	
	@Test
	public void checkAValid13DigitISBN() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkISBN("9780345434869");
		assertTrue("First value", result);
		result = validator.checkISBN("9781938895302");
		assertTrue("Second value", result);
	}
	
	@Test
	public void tenDigitISBNNumbersEndingInAnXAreValid() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalid10DigitISBN() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void checkAnInvalid13DigitISBN() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkISBN("9781938895306");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nineDigitISBNsAreNotAllowed() {
		ISBNValidator validator = new ISBNValidator();
		validator.checkISBN("123456789");
	}
	
	@Test(expected = NumberFormatException.class)
	public void noneNumericISBNsAreNotAllowed() {
		ISBNValidator validator = new ISBNValidator();
		validator.checkISBN("helloworld");
	}

}
