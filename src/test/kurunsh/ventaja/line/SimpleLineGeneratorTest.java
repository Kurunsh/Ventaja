package kurunsh.ventaja.line;

import helper.TestBuildHelper;
import helper.TestConstants;
import kurunsh.ventaja.attribute.SimpleAttributeBuilder;
import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.datapool.Datapool;
import kurunsh.ventaja.exceptions.LineConverterException;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class SimpleLineGeneratorTest {

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
    Assert.assertEquals(Integer.valueOf(1), classToTest.getColumnCount());
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
    Assert.assertEquals(Integer.valueOf(1), classToTest.getColumnCount());
  }

  @Test
  public void addAttributeTestAddAtPosition() {
    final Attribute attribute1 = TestBuildHelper.buildEmptyAttribute(TestConstants.ATTRIBUTE_VALUE_1);
    final Attribute attribute2 = TestBuildHelper.buildEmptyAttribute(TestConstants.ATTRIBUTE_VALUE_2);
    final Attribute attribute3 = TestBuildHelper.buildEmptyAttribute(TestConstants.ATTRIBUTE_VALUE_3);
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .build();
    classToTest.addAttributeAtPosition(attribute3,1);
    Assert.assertEquals(Integer.valueOf(3), classToTest.getColumnCount());
    Assert.assertEquals(attribute1, classToTest.getAttributes().get(0));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(1));
    Assert.assertEquals(attribute2, classToTest.getAttributes().get(2));
  }

  @Test
  public void addAttributeTestPutAtPosition() {
    final Attribute attribute1 = TestBuildHelper.buildEmptyAttribute(TestConstants.ATTRIBUTE_VALUE_1);
    final Attribute attribute2 = TestBuildHelper.buildEmptyAttribute(TestConstants.ATTRIBUTE_VALUE_2);
    final Attribute attribute3 = TestBuildHelper.buildEmptyAttribute(TestConstants.ATTRIBUTE_VALUE_3);
    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    classToTest.putAttributeAtPosition(attribute3,1);
    Assert.assertEquals(Integer.valueOf(3), classToTest.getColumnCount());
    Assert.assertEquals(attribute1, classToTest.getAttributes().get(0));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(1));
    Assert.assertEquals(attribute3, classToTest.getAttributes().get(2));
  }

  @Test
  public void createLineSingleValues() {

    final Datapool<String> datapool1 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_1,
            TestConstants.FIRSTNAMES_SINGLE);
    final Datapool<String> datapool2 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_2,
            TestConstants.LASTNAMES_SINGLE);
    final Datapool<String> datapool3 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_3,
            TestConstants.CITIES_SINGLE);

    final Attribute attribute1 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_1, datapool1);
    final Attribute attribute2 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_2, datapool2);
    final Attribute attribute3 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_3, datapool3);

    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withCellSeperator(TestConstants.CELL_SEPERATOR)
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    final Line line = classToTest.createLine();
    try {
      Assert.assertEquals("Alfred;Meier;Hamburg;", line.getFullLineAsString());
    } catch (LineConverterException exception) {
      System.out.println(exception.getMessage());
    }
  }

  @Test
  public void createLineMultiValues() {

    final Datapool<String> datapool1 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_1,
            TestConstants.FIRSTNAMES);
    final Datapool<String> datapool2 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_2,
            TestConstants.LASTNAMES);
    final Datapool<String> datapool3 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_3,
            TestConstants.CITIES);

    final Attribute attribute1 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_1, datapool1);
    final Attribute attribute2 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_2, datapool2);
    final Attribute attribute3 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_3, datapool3);

    final SimpleLineGenerator classToTest
            = SimpleLineGeneratorBuilder
            .create()
            .withCellSeperator(TestConstants.CELL_SEPERATOR)
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .build();
    final Line line = classToTest.createLine();
    Assert.assertFalse(TestConstants.FIRSTNAMES
            .stream()
            .filter(string -> {
              try {
                return line.getFullLineAsString().contains(string);
              } catch (LineConverterException exception) {
                System.out.println(exception.getMessage());
                return false;
              }
            })
            .collect(Collectors.toList())
            .isEmpty());
  }
}
