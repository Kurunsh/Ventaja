package org.kurunsh.ventaja.cell;

class SimpleStringCell implements Cell<String> {

  private String name;
  private String value;

  public SimpleStringCell( final String name, final String value ) {
    this.name = name;
    this.value = value;
  }

  SimpleStringCell( ) {
    this.name = "";
    this.value = "";
  }

  @Override
  public String getHeadline() {
    return name;
  }

  @Override
  public String getValue() {
    return getValueAsString();
  }

  @Override
  public String getValueAsString() {
    return value;
  }

  void setName(final String name) {
    this.name = name;
  }

  void setValue(final String value) {
    this.value = value;
  }
}
