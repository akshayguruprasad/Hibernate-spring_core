package com.indream.util;

import java.util.Scanner;

import com.indream.model.User;

public class Utility {

	private static final Scanner scanner = new Scanner(System.in);

	public static String getString() {

		return scanner.nextLine();

	}

	public static int getInt() {
		int data = scanner.nextInt();
		scanner.nextLine();
		return data;
	}

	public static User getUser() {
		System.out.println("Enter the details to be saved");

		String name;
		String email;
		String password;
		String mobile;
		System.out.println("Enter user name");
		name = Utility.getString();
		System.out.println("Enter user email");
		email = Utility.getString();
		System.out.println("Enter user password");
		password = Utility.getString();
		System.out.println("Enter user mobile");
		mobile = Utility.getString();
		User user = new User(name, mobile, email, password);
		return user;
	}
}
