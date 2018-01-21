package kurunsh.ventaja.generator.impl;

import helper.TestBuildHelper;
import kurunsh.ventaja.builder.impl.SimpleAttributeBuilder;
import kurunsh.ventaja.builder.impl.SimpleLineGeneratorBuilder;
import kurunsh.ventaja.model.in.Attribute;
import kurunsh.ventaja.model.in.Datapool;
import kurunsh.ventaja.model.out.Line;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleLineGeneratorTest {

  private static final String ATTRIBUTE_VALUE_1 = "attribute1";
  private static final String ATTRIBUTE_VALUE_2 = "attribute2";
  private static final String ATTRIBUTE_VALUE_3 = "attribute3";

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
  public void addAttributeTestAddAttribute() {
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
  public void addAttributeTestAddNull() {
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
  public void addAttributeTestAddAtPosition() {
    final Attribute attribute1 = TestBuildHelper.buildEmptyAttribute(ATTRIBUTE_VALUE_1);
    final Attribute attribute2 = TestBuildHelper.buildEmptyAttribute(ATTRIBUTE_VALUE_2);
    final Attribute attribute3 = TestBuildHelper.buildEmptyAttribute(ATTRIBUTE_VALUE_3);
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
  public void addAttributeTestPutAtPosition() {
    final Attribute attribute1 = TestBuildHelper.buildEmptyAttribute(ATTRIBUTE_VALUE_1);
    final Attribute attribute2 = TestBuildHelper.buildEmptyAttribute(ATTRIBUTE_VALUE_2);
    final Attribute attribute3 = TestBuildHelper.buildEmptyAttribute(ATTRIBUTE_VALUE_3);
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
  public void createLineSingleValues() {

    final Datapool<String> datapool1 = TestBuildHelper.buildDefaultStringDataPool(DATAPOOL_NAME_1, FIRSTNAMES_SINGLE);
    final Datapool<String> datapool2 = TestBuildHelper.buildDefaultStringDataPool(DATAPOOL_NAME_2, LASTNAMES_SINGLE);
    final Datapool<String> datapool3 = TestBuildHelper.buildDefaultStringDataPool(DATAPOOL_NAME_3, CITIES_SINGLE);

    final Attribute attribute1 = TestBuildHelper.buildAttribute(ATTRIBUTE_VALUE_1, datapool1);
    final Attribute attribute2 = TestBuildHelper.buildAttribute(ATTRIBUTE_VALUE_2, datapool2);
    final Attribute attribute3 = TestBuildHelper.buildAttribute(ATTRIBUTE_VALUE_3, datapool3);

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

  @Test
  public void createLineMultiValues() {

    final Datapool<String> datapool1 = TestBuildHelper.buildDefaultStringDataPool(DATAPOOL_NAME_1, FIRSTNAMES);
    final Datapool<String> datapool2 = TestBuildHelper.buildDefaultStringDataPool(DATAPOOL_NAME_2, LASTNAMES);
    final Datapool<String> datapool3 = TestBuildHelper.buildDefaultStringDataPool(DATAPOOL_NAME_3, CITIES);

    final Attribute attribute1 = TestBuildHelper.buildAttribute(ATTRIBUTE_VALUE_1, datapool1);
    final Attribute attribute2 = TestBuildHelper.buildAttribute(ATTRIBUTE_VALUE_2, datapool2);
    final Attribute attribute3 = TestBuildHelper.buildAttribute(ATTRIBUTE_VALUE_3, datapool3);

    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withCellSeperator(CELL_SEPERATOR)
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    final Line line = classToTest.createLine();
    Assert.assertFalse(FIRSTNAMES
            .stream()
            .filter(string -> line.getFullLineAsString().contains(string))
            .collect(Collectors.toList())
            .isEmpty());
  }
}
