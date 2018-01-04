package main.kurunsh.ventaja.model.out.impl;

import main.kurunsh.ventaja.model.out.Cell;

public class SimpleStringCell implements Cell<String> {

  private String name;
  private String value;

  public SimpleStringCell( final String name, final String value ) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String getHeadline() {
    return name;
  }

  @Override
  public String getValue() {
    return getValueAsString();
  }

  @Override
  public String getValueAsString() {
    return value;
  }
}
