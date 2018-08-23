package kurunsh.ventaja.attribute;

import kurunsh.ventaja.datapool.Datapool;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
class SimpleAttribute implements Attribute<String> {
  private Datapool datapool;
  private String name;

  @Override
  public void setDataPool( final Datapool<String> dataPool) {
    this.datapool = dataPool;
  }

  @Override
  public String getValue() {
    return (String) this.datapool.getRandomValue();
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
