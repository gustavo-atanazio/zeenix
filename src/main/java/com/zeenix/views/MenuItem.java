package com.zeenix.views;

public record MenuItem(String label, Runnable action, MenuItemType type) {
  public MenuItem(String label, Runnable action) {
    this(label, action, MenuItemType.NORMAL);
  }
}