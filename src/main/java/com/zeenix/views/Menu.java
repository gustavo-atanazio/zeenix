package com.zeenix.views;

import java.util.List;
import java.util.Scanner;

public class Menu {
  private List<MenuItem> items;
  private Scanner scanner;
  private boolean running;

  public Menu(List<MenuItem> items) {
    this.items = items;
    this.scanner = new Scanner(System.in);
    this.running = true;
  }

  public Scanner getScanner() { return scanner; }

  public void start() {
    System.out.println("Bem-vindo ao Zeenix!");

    while (running) {
      displayMenu();
      processOption();
    }

    scanner.close();
  }

  private void displayMenu() {
    System.out.println("\nEscolha uma ação:\n");

    for (int i = 0; i < items.size(); i++) {
      System.out.printf("%d. %s%n", i + 1, items.get(i).label());
    }

    System.out.print("\nOpção: ");
  }

  private void processOption() {
    if (scanner.hasNextInt()) {
      int selectedOption = scanner.nextInt();

      if (selectedOption >= 1 && selectedOption <= items.size()) {
        MenuItem selectedItem = items.get(selectedOption - 1);
        selectedItem.action().run();
        
        if (selectedItem.type() == MenuItemType.EXIT) {
            running = false;
        }
      } else System.out.println("Opção inválida. Tente novamente.");
    } else {
      System.out.println("Digite um número válido!");
      scanner.next();
    }
  }
}