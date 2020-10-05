package org.kurunsh.ventaja.cell;

import org.kurunsh.ventaja.builder.Builder;

public final class SimpleStringCellBuilder implements Builder<Cell> {

  private final SimpleStringCell instance;

  @Override
  public Cell build() {
    return this.instance;
  }

  public static SimpleStringCellBuilder create() {
    return new SimpleStringCellBuilder();
  }

  private SimpleStringCellBuilder() {
    this.instance = new SimpleStringCell();
  }

  public SimpleStringCellBuilder withAttributeName(final String name) {
    this.instance.setName(name);
    return this;
  }

  public SimpleStringCellBuilder withAttributeValue(final Object value) {
    if ( value instanceof String ) {
      this.instance.setValue(String.valueOf(value));
    } else {
      this.instance.setValue("");
    }
    return this;
  }
}
