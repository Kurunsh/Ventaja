package org.kurunsh.ventaja.attribute;

import org.kurunsh.ventaja.builder.Builder;
import org.kurunsh.ventaja.datapool.Datapool;

public final class SimpleAttributeBuilder implements Builder<Attribute> {

  private final SimpleAttribute instance;

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
