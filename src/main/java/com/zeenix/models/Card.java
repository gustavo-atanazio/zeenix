package com.zeenix.models;

public class Card {
  private int id;
  private String number;
  private String flag;
  private double totalLimit;
  private double availableLimit;
  private int clientID;

  public Card(int id, String number, String flag, double totalLimit, double availableLimit, int clientID) {
    this.id = id;
    this.number = number;
    this.flag = flag;
    this.totalLimit = totalLimit;
    this.availableLimit = availableLimit;
    this.clientID = clientID;
  }

  public int getId() { return id; }
  public String getNumber() { return number; }
  public String getFlag() { return flag; }
  public double getTotalLimit() { return totalLimit; }
  public double getAvailableLimit() { return availableLimit; }
  public int getClientID() { return clientID; }

  @Override
  public String toString() {
    return """
    ID: %d
    Número: %s
    Bandeira: %s
    Limite total: %.2f
    Limite disponível: %.2f
    ID do cliente: %d
    ------------------------------
    """.formatted(id, number, flag, totalLimit, availableLimit, clientID);
  }
}