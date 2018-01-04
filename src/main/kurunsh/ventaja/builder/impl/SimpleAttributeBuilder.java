package main.kurunsh.ventaja.builder.impl;

import main.kurunsh.ventaja.builder.Builder;
import main.kurunsh.ventaja.model.in.Attribute;
import main.kurunsh.ventaja.model.in.Datapool;
import main.kurunsh.ventaja.model.in.impl.SimpleAttribute;

public class SimpleAttributeBuilder implements Builder<Attribute> {

  private SimpleAttribute instance;

  public static SimpleAttributeBuilder create() {
    return new SimpleAttributeBuilder();
  }

  private SimpleAttributeBuilder() {
    this.instance = new SimpleAttribute();
  }

  @Override
  public Attribute build() {
    return this.instance;
  }

  public SimpleAttributeBuilder withAttributeName(final String name) {
    this.instance.setName(name);
    return this;
  }

  public SimpleAttributeBuilder withDatapool(final Datapool<String> datapool) {
    this.instance.setDataPool(datapool);
    return this;
  }
}
