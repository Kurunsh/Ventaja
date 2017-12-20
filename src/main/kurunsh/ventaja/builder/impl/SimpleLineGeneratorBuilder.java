package main.kurunsh.ventaja.builder.impl;

import main.kurunsh.ventaja.builder.Builder;
import main.kurunsh.ventaja.generator.impl.SimpleLineGenerator;
import main.kurunsh.ventaja.model.in.Attribute;

public class SimpleLineGeneratorBuilder implements Builder<SimpleLineGenerator>{

  private SimpleLineGenerator instance;

  public static SimpleLineGeneratorBuilder create() {
    return new SimpleLineGeneratorBuilder();
  }

  private SimpleLineGeneratorBuilder() {
    this.instance = new SimpleLineGenerator();
  }

  public SimpleLineGeneratorBuilder withAttribute( final Attribute attribute) {
    this.instance.addAttribute(attribute);
    return this;
  }

  @Override
  public SimpleLineGenerator build() {
    return this.instance;
  }
}
