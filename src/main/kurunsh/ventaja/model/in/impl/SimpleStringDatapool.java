package main.kurunsh.ventaja.model.in.impl;

import main.kurunsh.ventaja.model.in.Datapool;

import java.util.List;

public class SimpleStringDatapool implements Datapool<String> {

  private String name;
  private List<String> values;

  public SimpleStringDatapool(final String name, final List<String> values) {
    this.name = name;
    this.values = values;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<String> getValues() {
    return values;
  }

  @Override
  public String getRandomValue() {
    final int randomIndex = (int) (Math.random() * values.size());
    return values.get(randomIndex);
  }
}
