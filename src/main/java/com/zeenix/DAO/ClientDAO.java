package com.zeenix.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zeenix.infra.ConnectionFactory;
import com.zeenix.models.Client;

public class ClientDAO {
  private final Connection connection = new ConnectionFactory().getConnection();

  public void insert(Client client) throws SQLException {
    final String query = "INSERT INTO clients (cpf, name, email, income) VALUES (?, ?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
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