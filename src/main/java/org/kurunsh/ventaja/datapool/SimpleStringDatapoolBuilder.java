package org.kurunsh.ventaja.datapool;

import org.kurunsh.ventaja.builder.Builder;

import java.util.List;

public final class SimpleStringDatapoolBuilder implements Builder<SimpleStringDatapool> {

  private final SimpleStringDatapool instance;

  public static SimpleStringDatapoolBuilder create(final String name, final List<String> values) {
    return new SimpleStringDatapoolBuilder(name, values);
  }

  private SimpleStringDatapoolBuilder(final String name, final List<String> values) {
    this.instance = new SimpleStringDatapool(name, values);
  }

  @Override
  public SimpleStringDatapool build() {
    return this.instance;
  }
}
