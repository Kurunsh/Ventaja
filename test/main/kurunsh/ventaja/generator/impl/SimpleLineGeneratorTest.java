package main.kurunsh.ventaja.generator.impl;

import main.kurunsh.ventaja.builder.impl.SimpleAttributeBuilder;
import main.kurunsh.ventaja.builder.impl.SimpleLineGeneratorBuilder;
import main.kurunsh.ventaja.model.in.Attribute;
import org.junit.Assert;
import org.junit.Test;

public class SimpleLineGeneratorTest {

  @Test
  public void addAttributeTest_addAttribute() {
    final Attribute attribute
            = SimpleAttributeBuilder
            .create()
            .build();
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute)
            .build();
    Assert.assertEquals(new Integer(1), classToTest.getColumnCount());
  }

  @Test
  public void addAttributeTest_addNull() {
    final Attribute attribute
            = SimpleAttributeBuilder
            .create()
            .build();
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute)
            .withAttribute(null)
            .build();
    Assert.assertEquals(new Integer(1), classToTest.getColumnCount());
  }

}
