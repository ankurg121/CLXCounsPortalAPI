package com.jilit.clxacademics.business;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class IDGenerationRandom {

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String generateNumber() {
	
		LocalDateTime datetime=LocalDateTime.now();
		String dd=String.valueOf(datetime.getDayOfMonth());
		String mm=String.valueOf(datetime.getMonthValue());
		String yyyy=String.valueOf(datetime.getYear());
		String hh=String.valueOf(datetime.getHour());
		String MM=String.valueOf(datetime.getMinute());
		String ss=String.valueOf(datetime.getSecond());
		String num=String.copyValueOf(randomNumber(5));
		String str="R".concat(num).concat(dd).concat(mm).concat(yyyy).concat(hh).concat(MM).concat(ss);
		return str;
	}
	static char[] randomNumber(int len) {
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String values = Capital_chars + numbers;
		Random rndm_method = new Random();
		char[] password = new char[len];

		for (int i = 0; i < len; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
		return password;
	}
	public static String generateRandomNumber(int len, int randNumOrigin, int randNumBound) {
		SecureRandom random = new SecureRandom();
		return random.ints(randNumOrigin, randNumBound + 1)
				.filter(i -> Character.isAlphabetic(i) || Character.isDigit(i)).limit(len)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

}
