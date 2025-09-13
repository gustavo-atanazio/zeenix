package com.zeenix.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zeenix.models.Client;

public class ClientDAO {
  private final String url = "jdbc:mysql://mysql:3306/zeenix";
  private final String user = "zeenix_user";
  private final String password = "zeenix_pass";

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  public void insert(Client client) throws SQLException {
    final String query = "INSERT INTO clients (cpf, name, email, income) VALUES (?, ?, ?, ?)";

    try (
      Connection connection = getConnection();
      PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, client.getCPF());
      statement.setString(2, client.getName());
      statement.setString(3, client.getEmail());
      statement.setDouble(4, client.getIncome());

      statement.executeUpdate();
    }
  }

  public List<Client> findAll() throws SQLException {
    final String query = "SELECT * FROM clients";
    List<Client> clients = new ArrayList<>();

    try (
      Connection connection = getConnection();
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(query)
    ) {
      while (result.next()) {
        Client client = new Client(
          result.getInt("id"),
          result.getString("cpf"),
          result.getString("name"),
          result.getString("email"),
          result.getDouble("income")
        );

        clients.add(client);
      }
    }

    return clients;
  }
}