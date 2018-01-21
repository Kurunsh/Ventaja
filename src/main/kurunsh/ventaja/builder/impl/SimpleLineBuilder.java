package kurunsh.ventaja.builder.impl;

import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.model.out.Cell;
import kurunsh.ventaja.model.out.Line;
import kurunsh.ventaja.model.out.impl.SimpleLine;

import java.util.List;

public class SimpleLineBuilder implements Builder<Line> {

  private SimpleLine instance;

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
