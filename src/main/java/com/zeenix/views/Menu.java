package com.zeenix.views;

import java.util.List;
import java.util.Scanner;

public class Menu {
  private List<MenuItem> items;

  public Menu(List<MenuItem> items) { this.items = items; }

  public void start() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bem-vindo ao Zeenix!");

    int selectedOption = -1;
    MenuItem selectedItem = null;

    while (selectedItem == null) {
      System.out.println("\nEscolha uma ação:\n");

      for (int i = 0; i < items.size(); i++) {
        System.out.printf("%d. %s%n", i + 1, items.get(i).label());
      }

      System.out.print("\nOpção: ");

      if (scanner.hasNextInt()) {
        selectedOption = scanner.nextInt();

        if (selectedOption >= 1 && selectedOption <= items.size()) selectedItem = items.get(selectedOption - 1);
        else System.out.println("Opção inválida. Tente novamente.");
      } else {
        System.out.println("Digite um número válido!");
        scanner.next();
      }
    }

    selectedItem.action().run();
    scanner.close();
  }
}