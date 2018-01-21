package helper;

import kurunsh.ventaja.builder.impl.SimpleAttributeBuilder;
import kurunsh.ventaja.builder.impl.SimpleStringDatapoolBuilder;
import kurunsh.ventaja.model.in.Attribute;
import kurunsh.ventaja.model.in.Datapool;

import java.util.List;

public class TestBuildHelper {

  public static Attribute buildEmptyAttribute(final String name ) {
    return SimpleAttributeBuilder
            .create()
            .withAttributeName(name)
            .build();
  }

  public static Attribute buildAttribute(final String name, final Datapool<String> datapool ) {
    return SimpleAttributeBuilder
            .create()
            .withAttributeName(name)
            .withDatapool(datapool)
            .build();
  }

  public static Datapool<String> buildDefaultStringDataPool(final String name, final List<String> values ) {
    return SimpleStringDatapoolBuilder
            .create(name, values)
            .build();
  }

}
