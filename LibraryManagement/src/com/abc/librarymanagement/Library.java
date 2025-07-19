package com.abc.librarymanagement;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Library {

	public void addBook(Book book) {
		String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";

		try (Connection conn = DbConnection.getconnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setInt(3, book.getYear());

			stmt.executeUpdate();
			System.out.println("Book added to database.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewBooks() {
		String sql = "SELECT * FROM books";

		try (Connection conn = DbConnection.getconnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Author: "
						+ rs.getString("author") + ", Year: " + rs.getInt("year"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchBook(String title) {
		String sql = "SELECT * FROM books WHERE title LIKE ?";

		try (Connection conn = DbConnection.getconnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, "%" + title + "%");
			ResultSet rs = stmt.executeQuery();

			boolean found = false;
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Author: "
						+ rs.getString("author") + ", Year: " + rs.getInt("year"));
				found = true;
			}

			if (!found) {
				System.out.println("No matching book found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
