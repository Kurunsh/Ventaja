package org.kurunsh.ventaja.datapool;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
class SimpleStringDatapool implements Datapool<String> {

  private final String name;
  private final List<String> values;

  SimpleStringDatapool(final String name, final List<String> values) {
    this.name = name;
    this.values = values;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<String> getValues() {
    return values;
  }

  @Override
  public String getRandomValue() {
    final int randomIndex = (int) (Math.random() * values.size());
    return values.get(randomIndex);
  }
}
