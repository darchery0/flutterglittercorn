package org.communityapp.data;

import java.sql.*;
import java.util.Scanner;

public class VulnerableLoginTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String userInput = scanner.nextLine();
        System.out.print("Enter Password: ");
        String passInput = scanner.nextLine();

        // ⚠️ UNSAFE CONCATENATION
        String sql = "SELECT * FROM users WHERE username = '" + userInput + "' AND password_hash = '" + passInput + "'";
        System.out.println("DEBUG SQL EXECUTED: " + sql);

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("🚨 BREACH SUCCESSFUL! Logged in as: " + rs.getString("username") + " (Role: " + rs.getString("user_role") + ")");
            } else {
                System.out.println("Login failed.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
