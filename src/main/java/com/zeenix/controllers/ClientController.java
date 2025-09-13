package com.zeenix.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.zeenix.DAO.ClientDAO;
import com.zeenix.models.Client;

public class ClientController {
  private final ClientDAO clientDAO = new ClientDAO();

  public void createClient() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o CPF: ");
    String cpf = scanner.nextLine();

    System.out.println("Digite o nome: ");
    String name = scanner.nextLine();

    System.out.println("Digite o email: ");
    String email = scanner.nextLine();

    System.out.println("Digite a renda mensal (no formato: 1000.00): ");
    double income = scanner.nextDouble();

    try {
      Client client = new Client(cpf, name, email, income);

      System.out.println("Adicionando novo cliente no banco...");
      clientDAO.insert(client);

      System.out.println("Cliente adicionado com sucesso!");
    } catch (SQLException exception) {
      System.out.println("Erro ao adicionar cliente: " + exception.getMessage());
    }

    scanner.close();
  }

  public List<Client> listClients() {
    try {
      return clientDAO.findAll();
    } catch (SQLException exception) {
      System.out.println("Erro ao listar clientes: " + exception.getMessage());
      return null;
    }
  }
}