package kurunsh.ventaja.datapool;

import kurunsh.ventaja.builder.Builder;

import java.util.List;

public class SimpleStringDatapoolBuilder implements Builder<SimpleStringDatapool> {

  private SimpleStringDatapool instance;

  public static SimpleStringDatapoolBuilder create(final String name, final List<String> values) {
    return new SimpleStringDatapoolBuilder(name, values);
  }

  public SimpleStringDatapoolBuilder(final String name, final List<String> values) {
    this.instance = new SimpleStringDatapool(name, values);
  }

  @Override
  public SimpleStringDatapool build() {
    return this.instance;
  }
}
