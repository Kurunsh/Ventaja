package main.kurunsh.ventaja.builder.impl;

import main.kurunsh.ventaja.builder.Builder;
import main.kurunsh.ventaja.model.out.Cell;
import main.kurunsh.ventaja.model.out.Line;
import main.kurunsh.ventaja.model.out.impl.SimpleLine;

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
}
