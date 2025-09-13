package com.zeenix.BO;

import java.util.List;

import com.zeenix.errors.BusinessRuleException;
import com.zeenix.models.Client;

public class ClientBO {
  public static void verifyDuplicity(Client client, List<Client> clients) throws BusinessRuleException {
    if (verifyCPFDuplicity(client, clients) || verifyEmailDuplicity(client, clients)) {
      throw new BusinessRuleException("Já existe um cliente com o mesmo CPF ou email.");
    }
  }

  public static boolean verifyCPFDuplicity(Client client, List<Client> clients) {
    boolean hasDuplicity = false;

    for (Client clientItem: clients) {
      if (clientItem != client && clientItem.getCPF().equals(client.getCPF())) {
        hasDuplicity = true;
        break;
      }
    }

    return hasDuplicity;
  }

  public static boolean verifyEmailDuplicity(Client client, List<Client> clients) {
    boolean hasDuplicity = false;

    for (Client clientItem: clients) {
      if (clientItem != client && clientItem.getEmail().equals(client.getEmail())) {
        hasDuplicity = true;
        break;
      }
    }

    return hasDuplicity;
  }
}