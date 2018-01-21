package kurunsh.ventaja.builder.impl;

import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.generator.impl.SimpleLineGenerator;
import kurunsh.ventaja.model.in.Attribute;

public class SimpleLineGeneratorBuilder implements Builder<SimpleLineGenerator> {

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

  public SimpleLineGeneratorBuilder withCellSeperator(final String lineSeperator) {
    this.instance.setCellSeperator(lineSeperator);
    return this;
  }

  @Override
  public SimpleLineGenerator build() {
    return this.instance;
  }

}
