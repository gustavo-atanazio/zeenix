package com.zeenix.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.zeenix.BO.ClientBO;
import com.zeenix.DAO.ClientDAO;
import com.zeenix.errors.BusinessRuleException;
import com.zeenix.models.Client;

public class ClientController {
  private final ClientDAO clientDAO = new ClientDAO();
  private Scanner scanner;

  public ClientController(Scanner scanner) {
    this.scanner = scanner;
  }

  public void createClient() {
    scanner.nextLine();
    
    System.out.println("Digite o CPF: ");
    String cpf = scanner.nextLine();

    System.out.println("Digite o nome: ");
    String name = scanner.nextLine();

    System.out.println("Digite o email: ");
    String email = scanner.nextLine();

    System.out.println("Digite a renda mensal (no formato: 1000.00): ");
    double income;

    try {
      income = Double.parseDouble(scanner.nextLine());
    } catch (NumberFormatException exception) {
      System.out.println("Erro: Valor de renda inválido. Use o formato correto (exemplo: 1000.00)");
      return;
    }

    try {
      Client client = new Client(cpf, name, email, income);
      ClientBO.verifyDuplicity(client, listClients());

      System.out.println("Adicionando novo cliente no banco...");
      clientDAO.insert(client);

      System.out.println("Cliente adicionado com sucesso!");
    } catch (BusinessRuleException | SQLException exception) {
      System.out.println("Erro ao adicionar cliente: " + exception.getMessage());
    }
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