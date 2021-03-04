package com.jilit.clxacademics.util;
import java.text.NumberFormat;

//For the purpose of Floor of Hostel Only since Ground , First ect will be used here
// Ashok kr Singh
public class NumberToWordsConverter {

	public static final String[] units = { "Ground", "First", "Second", "Third", "Fourth",
			"Fifth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth", "Eleventh", "Twelfth",
			"Thirteenth", "Fourteenth", "Fifteenth", "Sixteenth", "Seventeenth",
			"Eighteenth", "Nineteenth" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}
         
		if (n == 20) {
			return "Twentieth";
		}
		if (n == 30) {
			return "Thirtieth";
		}
		if (n == 40) {
			return "Fourtieth";
		}
		if (n == 50) {
			return "Fiftieth";
		}
		if (n == 60) {
			return "Sixtieth";
		}
		if (n == 70) {
			return "Seventieth";
		}
		if (n == 80) {
			return "Eightieth";
		}
		if (n == 90) {
			return "Ninetieth";
		}
		
		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

//	public static void main(final String[] args) {
//
//		int n;
//        for(n=0;n<15;n++)
//		System.out.println("\n"+NumberFormat.getInstance().format(n) + "='" + convert(n) + "'");
//
//	}
}
 