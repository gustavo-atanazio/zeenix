package com.zeenix.models;

public class Client {
  private int id;
  private String cpf;
  private String name;
  private String email;
  private double income;

  public Client(int id, String cpf, String name, String email, double income) {
    this.id = id;
    this.cpf = cpf;
    this.name = name;
    this.email = email;
    this.income = income;
  }

  public Client(String cpf, String name, String email, double income) {
    this.cpf = cpf;
    this.name = name;
    this.email = email;
    this.income = income;
  }

  public int getID() { return id; }
  public String getCPF() { return cpf; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public double getIncome() { return income; }

  @Override
  public String toString() {
    return """
    ID: %d
    CPF: %s
    Nome: %s
    Email: %s
    Renda mensal: %.2f
    ------------------------------
    """.formatted(id, cpf, name, email, income);
  }
}