package com.java.project;

public class TestDisposer {

	public static void main(String[] args) {
		AddPassword.startAddPasswordScreen(() -> {
			System.out.println("Record Entered");
		});
	}

}
