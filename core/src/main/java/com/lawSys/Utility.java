package com.lawSys;

import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utility {
//
//	public static String GetUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
//    	    String currentUserName = authentication.getName();
//    	    return currentUserName;
//    	}
//		return null;
//	}
//	
	
	
	public static Integer ParseInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static LocalDate ParseDateISOString(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		try {
			return LocalDate.parse(value, formatter);
		} catch (Exception e) {
			System.out.println(value +"      "+e.getMessage());
			//e.printStackTrace();
			return null;
		}
	}
}