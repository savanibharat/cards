package com.learninghorizon.misc;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.learninghorizon.cards.InValidCardDetails;

public class Validate {
	
	private Validate(){
		throw new AssertionError(
			"Don't try to access Private constructor."
		);
	}
	
	public static void validateNullAndEmpty(
			final String input,
			final String message) {
		if (input == null || StringUtils.isEmpty(input.trim())) {
			throw new IllegalArgumentException(
				message
			);
		}
	}

	public static void validateNull(
			final Object input, 
			String message){
		
		if(input == null){
			throw new IllegalArgumentException(
				message
			);
		}
	}
	
	public static void validateNull(
			final Object input){
		
		if (input == null) {
			throw new IllegalArgumentException(
				"Parameter should not be null"
			);
		}
	}
	
	//a-z
	//0-9
	//3 to 15 alphanumeric
	private static final String USERNAME_PATTERN = "^[a-z0-9_]{3,15}$";
	public static void validateUserName(
			final String userName, 
			final String exceptionMessage) {
		
		validateNullAndEmpty(userName, exceptionMessage);

		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Matcher matcher = pattern.matcher(userName);
		if (matcher.matches()) {
			return;
		}
		throw new IllegalArgumentException(
			exceptionMessage
		);
	}
	
	public static boolean validateCollectionNotNull(Collection<?> coll, String message){
		if(null != coll){
			return true;
		}
		throw new InValidCardDetails(
			message
		);
	}
	
}
