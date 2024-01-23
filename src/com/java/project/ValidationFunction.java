package com.java.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationFunction {
	public static boolean isValidURL(String url) {
		String urlRegex = "^(https?|ftp)://.*$";
		Pattern pattern = Pattern.compile(urlRegex);
		Matcher matcher = pattern.matcher(url);
		return matcher.matches();
	}

	public static boolean isValidUsername(String username) {
		return username.matches("[a-zA-Z0-9_]+");
	}

	public static boolean isValidPassword(String password) {
		String regex = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=])(?=.*[0-9]).{8,}$";
		return password.matches(regex);
	}
}
