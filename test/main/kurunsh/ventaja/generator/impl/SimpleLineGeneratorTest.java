package main.kurunsh.ventaja.generator.impl;

import main.kurunsh.ventaja.builder.impl.SimpleAttributeBuilder;
import main.kurunsh.ventaja.builder.impl.SimpleLineGeneratorBuilder;
import main.kurunsh.ventaja.model.in.Attribute;
import org.junit.Assert;
import org.junit.Test;

public class SimpleLineGeneratorTest {

  private static final String ATTRIBUTE_1 = "attribute1";
  private static final String ATTRIBUTE_2 = "attribute2";
  private static final String ATTRIBUTE_3 = "attribute3";

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

  @Test
  public void addAttributeTest_addAtPosition() {
    final Attribute attribute = buildDefaultAttribute(ATTRIBUTE_1);
    final Attribute attribute2 = buildDefaultAttribute(ATTRIBUTE_2);
    final Attribute attribute3 = buildDefaultAttribute(ATTRIBUTE_3);
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute)
            .withAttribute(attribute2)
            .build();
    classToTest.addAttributeAtPosition(attribute3,1);
    Assert.assertEquals(new Integer(3), classToTest.getColumnCount());
    Assert.assertEquals(attribute, classToTest.getAttributes().get(0));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(1));
    Assert.assertEquals(attribute2, classToTest.getAttributes().get(2));
  }

  @Test
  public void addAttributeTest_putAtPosition() {
    final Attribute attribute = buildDefaultAttribute(ATTRIBUTE_1);
    final Attribute attribute2 = buildDefaultAttribute(ATTRIBUTE_2);
    final Attribute attribute3 = buildDefaultAttribute(ATTRIBUTE_3);
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    classToTest.putAttributeAtPosition(attribute3,1);
    Assert.assertEquals(new Integer(3), classToTest.getColumnCount());
    Assert.assertEquals(attribute, classToTest.getAttributes().get(0));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(1));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(2));
  }

  private Attribute buildDefaultAttribute( final String name ) {
    return SimpleAttributeBuilder
            .create()
            .withAttributeName(name)
            .build();
  }

}
