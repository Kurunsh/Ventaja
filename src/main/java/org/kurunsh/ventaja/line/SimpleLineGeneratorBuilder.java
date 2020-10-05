package org.kurunsh.ventaja.line;

import org.kurunsh.ventaja.attribute.Attribute;
import org.kurunsh.ventaja.builder.Builder;

public final class SimpleLineGeneratorBuilder implements Builder<SimpleLineGenerator> {

  private final SimpleLineGenerator instance;

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

  public SimpleLineGeneratorBuilder withLineCount(final int lineCount) {
    this.instance.setLineCount(lineCount);
    return this;
  }
}
