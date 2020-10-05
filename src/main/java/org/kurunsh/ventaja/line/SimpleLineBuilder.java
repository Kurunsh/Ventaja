package org.kurunsh.ventaja.line;

import org.kurunsh.ventaja.builder.Builder;

final class SimpleLineBuilder implements Builder<Line> {

  private final SimpleLine instance;

  public static SimpleLineBuilder create() {
    return new SimpleLineBuilder();
  }

  private SimpleLineBuilder() {
    this.instance = new SimpleLine();
  }

  @Override
  public Line build() {
    return this.instance;
  }

  public SimpleLineBuilder withCellSeperator(final String cellSeperator) {
    this.instance.setCellSeperator(cellSeperator);
    return this;
  }
}
