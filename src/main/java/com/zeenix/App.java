package com.zeenix;

import java.util.ArrayList;
import java.util.List;

import com.zeenix.views.Menu;
import com.zeenix.views.MenuItem;

public class App {
  public static void main(String[] args) {
    List<MenuItem> items = new ArrayList<>();
    Menu menu = new Menu(items);

    items.add(new MenuItem("Cadastrar cliente", () -> {}));
    items.add(new MenuItem("Solicitar cartão", () -> {}));
    items.add(new MenuItem("Registrar transação", () -> {}));
    items.add(new MenuItem("Consultar fatura", () -> {}));
    items.add(new MenuItem("Pagar fatura", () -> {}));
    items.add(new MenuItem("Consultar clientes/cartões", () -> {}));
    items.add(new MenuItem("Sair", () -> System.out.println("\nObrigado por usar o Zeenix!")));

    menu.start();
  }
}