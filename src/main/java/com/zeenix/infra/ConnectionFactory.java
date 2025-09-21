package com.zeenix.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  private final String URL = "jdbc:mysql://mysql:3306/zeenix";
  private final String USER = "zeenix_user";
  private final String PASSWORD = "zeenix_pass";

  public Connection getConnection() {
    try {
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) { throw new RuntimeException(e); }
  }
}