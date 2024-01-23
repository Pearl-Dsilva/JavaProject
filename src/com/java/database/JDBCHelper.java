package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.encryption.Encryption;
/**
 * CREATE DATABASE Vault;
 * USE Vault;
 * CREATE TABLE users_details (uid INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(25) NOT NULL, password VARCHAR(25) NOT NULL);
 * SELECT * FROM users_details;
 * 
 * CREATE TABLE passwordManager (id INT PRIMARY KEY AUTO_INCREMENT, url VARCHAR(255) ,username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL);
 */


public class JDBCHelper {

	private static final String DB_URL = "jdbc:mysql://localhost/Vault";
	private static final String USER = "root";
	private static final String PASS = "Zombie@2347245";
	private static final String TABLE_NAME = "passwordManager";

	static final String[] columnNames = { "id", "url", "username", "password" };

	public static ArrayList<DataModel> read() {
		final String QUERY = String.format("SELECT * FROM %s", TABLE_NAME);
		ArrayList<DataModel> results = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				ResultSet rs = conn.createStatement().executeQuery(QUERY)) {

			while (rs.next()) {
				try {
					String decryptedPassword = new Encryption().decrypt(rs.getString("password"));
					DataModel dataModel = new DataModel(rs.getInt("id"), rs.getString("url"), rs.getString("username"),
							decryptedPassword);

					results.add(dataModel);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static int update(DataModel dataModel) {
		int rowsUpdated = 0;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			Encryption encryption = new Encryption();
			String encryptedPassword = encryption.encrypt(dataModel.getPassword());

			final String QUERY = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?", TABLE_NAME,
					columnNames[1], columnNames[2], columnNames[3], columnNames[0]);

			try (PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
				preparedStatement.setString(1, dataModel.getUrl());
				preparedStatement.setString(2, dataModel.getUsername());
				preparedStatement.setString(3, encryptedPassword);
				preparedStatement.setInt(4, dataModel.getId());
				rowsUpdated = preparedStatement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	public static int insert(DataModel dataModel) {
		int rowsInserted = 0;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			Encryption encryption = new Encryption();
			String encryptedPassword = encryption.encrypt(dataModel.getPassword());

			final String QUERY = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", TABLE_NAME,
					columnNames[1], columnNames[2], columnNames[3]);

			try (PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
				preparedStatement.setString(1, dataModel.getUrl());
				preparedStatement.setString(2, dataModel.getUsername());
				preparedStatement.setString(3, encryptedPassword);
				rowsInserted = preparedStatement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsInserted;
	}

	public static int delete(int id) {
		int rowsDeleted = 0;
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			final String QUERY = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, columnNames[0]);

			try (PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
				preparedStatement.setInt(1, id);
				rowsDeleted = preparedStatement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	// Example usage
//	public static void main(String[] args) {
//
//		ArrayList<DataModel> databaseContent = read();// Insert Example using DataModel
//		DataModel newDataModel = new DataModel(1, "oldURL", "oldUsername", "oldPassword");
//		int insertedRows = insert(newDataModel);
//		System.out.println("Inserted Rows: " + insertedRows);
//
//		// Update Example using DataModel
//		DataModel updatedDataModel = new DataModel(2, "newURL", "newUsername", "newPassword");
//		int updatedRows = update(updatedDataModel);
//		System.out.println("Updated Rows: " + updatedRows);
//
//		// Delete Example
//		int deletedRows = delete(1);
//		System.out.println("Deleted Rows: " + deletedRows);
//	}
}
