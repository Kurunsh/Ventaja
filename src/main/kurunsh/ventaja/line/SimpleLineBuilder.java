package kurunsh.ventaja.line;

import kurunsh.ventaja.builder.Builder;

class SimpleLineBuilder implements Builder<Line> {

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
