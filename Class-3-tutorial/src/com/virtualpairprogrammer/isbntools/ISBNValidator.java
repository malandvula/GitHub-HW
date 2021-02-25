package com.virtualpairprogrammer.isbntools;

public class ISBNValidator {

	private static final int LONGISBNMULTIPLIER = 10;
	private static final int SHORTISBNMULTIPLIER = 11;
	private static final int SHORTISBNLENGTH = 10;
	private static final int LONGISBNLENGTH = 13;

	public boolean checkISBN(String isbn) {
		if (isbn.length() == LONGISBNLENGTH) {
			return isThisAValidLongDigitISBN(isbn);
		}else if (isbn.length() == SHORTISBNLENGTH){
			return isThisAValidShortDigitISBN(isbn);
		}	
		throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long");
	}

	private boolean isThisAValidShortDigitISBN(String isbn) {
		int total = 0;
		
		for (int i = 0; i < SHORTISBNLENGTH; i++) {
			if(!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					total += 10;
				}
				else {
					throw new NumberFormatException("ISBN numbers can only contain numeric digits");
				}
							
			}else {
				total += Character.getNumericValue(isbn.charAt(i)) * (SHORTISBNLENGTH-i);
				}
		}
		
		return (total % SHORTISBNMULTIPLIER == 0);	
	}

	private boolean isThisAValidLongDigitISBN(String isbn) {
		int total = 0;
		
		for (int i = 0; i < LONGISBNLENGTH; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			}else {
				total += Character.getNumericValue(isbn.charAt(i)) *3;
			}
		}
		
		return (total % LONGISBNMULTIPLIER == 0);
	}

}
