package main.kurunsh.ventaja.generator.impl;

import main.kurunsh.ventaja.builder.impl.SimpleAttributeBuilder;
import main.kurunsh.ventaja.builder.impl.SimpleLineGeneratorBuilder;
import main.kurunsh.ventaja.builder.impl.SimpleStringDatapoolBuilder;
import main.kurunsh.ventaja.model.in.Attribute;
import main.kurunsh.ventaja.model.in.Datapool;
import main.kurunsh.ventaja.model.out.Line;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleLineGeneratorTest {

  private static final String ATTRIBUTE_1 = "attribute1";
  private static final String ATTRIBUTE_2 = "attribute2";
  private static final String ATTRIBUTE_3 = "attribute3";

  private static final String DATAPOOL_NAME_1 = "Datapool 1";
  private static final String DATAPOOL_NAME_2 = "Datapool 2";
  private static final String DATAPOOL_NAME_3 = "Datapool 3";

  private static final String CELL_SEPERATOR = ";";

  private static final List<String> FIRSTNAMES_SINGLE = Collections.singletonList("Alfred");
  private static final List<String> LASTNAMES_SINGLE = Collections.singletonList("Meier");
  private static final List<String> CITIES_SINGLE = Collections.singletonList("Hamburg");

  private static final List<String> FIRSTNAMES = Arrays.asList("Alfred","Agnes","Bertram");
  private static final List<String> LASTNAMES = Arrays.asList("Meier","Müller","Schulze");
  private static final List<String> CITIES = Arrays.asList("Hamburg","Leipzig","Berlin");

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
    final Attribute attribute1 = buildEmptyAttribute(ATTRIBUTE_1);
    final Attribute attribute2 = buildEmptyAttribute(ATTRIBUTE_2);
    final Attribute attribute3 = buildEmptyAttribute(ATTRIBUTE_3);
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .build();
    classToTest.addAttributeAtPosition(attribute3,1);
    Assert.assertEquals(new Integer(3), classToTest.getColumnCount());
    Assert.assertEquals(attribute1, classToTest.getAttributes().get(0));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(1));
    Assert.assertEquals(attribute2, classToTest.getAttributes().get(2));
  }

  @Test
  public void addAttributeTest_putAtPosition() {
    final Attribute attribute1 = buildEmptyAttribute(ATTRIBUTE_1);
    final Attribute attribute2 = buildEmptyAttribute(ATTRIBUTE_2);
    final Attribute attribute3 = buildEmptyAttribute(ATTRIBUTE_3);
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    classToTest.putAttributeAtPosition(attribute3,1);
    Assert.assertEquals(new Integer(3), classToTest.getColumnCount());
    Assert.assertEquals(attribute1, classToTest.getAttributes().get(0));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(1));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(2));
  }

  @Test
  public void createLine_singleValues() {

    final Datapool<String> datapool1 = buildDefaultStringDataPool(DATAPOOL_NAME_1, FIRSTNAMES_SINGLE);
    final Datapool<String> datapool2 = buildDefaultStringDataPool(DATAPOOL_NAME_2, LASTNAMES_SINGLE);
    final Datapool<String> datapool3 = buildDefaultStringDataPool(DATAPOOL_NAME_3, CITIES_SINGLE);

    final Attribute attribute1 = buildAttribute(ATTRIBUTE_1, datapool1);
    final Attribute attribute2 = buildAttribute(ATTRIBUTE_2, datapool2);
    final Attribute attribute3 = buildAttribute(ATTRIBUTE_3, datapool3);

    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withCellSeperator(CELL_SEPERATOR)
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    final Line line = classToTest.createLine();
    Assert.assertEquals("Alfred;Meier;Hamburg;", line.getFullLineAsString());
  }

  private Attribute buildEmptyAttribute(final String name ) {
    return SimpleAttributeBuilder
            .create()
            .withAttributeName(name)
            .build();
  }

  private Attribute buildAttribute(final String name, final Datapool<String> datapool ) {
    return SimpleAttributeBuilder
            .create()
            .withAttributeName(name)
            .withDatapool(datapool)
            .build();
  }

  private Datapool<String> buildDefaultStringDataPool(final String name, final List<String> values ) {
    return SimpleStringDatapoolBuilder
            .create(name, values)
            .build();
  }

}
