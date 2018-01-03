package main.kurunsh.ventaja.model.in.impl;

import main.kurunsh.ventaja.model.in.Attribute;
import main.kurunsh.ventaja.model.in.Datapool;

public class SimpleAttribute implements Attribute<String> {

  private String value;
  private String name;

  @Override
  public void setDataPool( final Datapool<String> dataPool) {

  }

  @Override
  public String getValue() {
    return null;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
