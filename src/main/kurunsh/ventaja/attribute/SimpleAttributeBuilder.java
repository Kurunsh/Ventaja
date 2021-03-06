package kurunsh.ventaja.attribute;

import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.datapool.Datapool;

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
