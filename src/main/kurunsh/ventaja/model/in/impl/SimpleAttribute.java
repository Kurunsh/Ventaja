package kurunsh.ventaja.model.in.impl;

import kurunsh.ventaja.model.in.Attribute;
import kurunsh.ventaja.model.in.Datapool;

public class SimpleAttribute implements Attribute<String> {

  private Datapool datapool;
  private String name;

  @Override
  public void setDataPool( final Datapool<String> dataPool) {
    this.datapool = dataPool;
  }

  @Override
  public String getValue() {
    return (String) this.datapool.getRandomValue();
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
