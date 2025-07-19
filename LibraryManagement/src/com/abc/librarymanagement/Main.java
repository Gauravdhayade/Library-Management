package com.abc.librarymanagement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Library Menu ---");
			System.out.println("1. Add Book");
			System.out.println("2. View All Books");
			System.out.println("3. Search Book by Title");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter Book Title: ");
				String title = scanner.nextLine();

				System.out.print("Enter Author Name: ");
				String author = scanner.nextLine();

				System.out.print("Enter Year Published: ");
				int year = scanner.nextInt();

				Book book = new Book(title, author, year);
				library.addBook(book);
				break;

			case 2:
				library.viewBooks();
				break;

			case 3:
				System.out.print("Enter Title to Search: ");
				String searchTitle = scanner.nextLine();
				library.searchBook(searchTitle);
				break;

			case 4:
				System.out.println("Exiting Library System.");
				break;

			default:
				System.out.println("Invalid choice.");
			}

		} while (choice != 4);

		scanner.close();

	}

}
