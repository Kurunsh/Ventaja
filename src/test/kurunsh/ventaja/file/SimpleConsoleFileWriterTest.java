package kurunsh.ventaja.file;

import helper.TestBuildHelper;
import helper.TestConstants;
import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.datapool.Datapool;
import kurunsh.ventaja.line.LineGenerator;
import kurunsh.ventaja.line.SimpleLineGeneratorBuilder;
import kurunsh.ventaja.message.Message;
import org.junit.Assert;
import org.junit.Test;

public class SimpleConsoleFileWriterTest {

  @Test
  public void writeFileTestNoFile() {
    final FileWriter classToTest
            = SimpleConsoleFileWriterBuilder
            .create()
            .build();
    final Message message = classToTest.writeFile(null);
    Assert.assertNotNull(message);
    Assert.assertTrue(message.isError());
    Assert.assertEquals(1, message.getMessages().size());
    Assert.assertEquals("Given file is null!", message.getMessages().get(0));
  }

  @Test
  public void writeFileTestEmptyLines() {
    final FileWriter classToTest
            = SimpleConsoleFileWriterBuilder
            .create()
            .build();
    final SimpleFileGenerator generator
            = SimpleFileGeneratorBuilder
            .create()
            .build();
    final Message message = classToTest.writeFile(generator.generateFile());
    Assert.assertNotNull(message);
    Assert.assertTrue(message.isError());
    Assert.assertEquals(1, message.getMessages().size());
    Assert.assertEquals("Given file contains no lines!", message.getMessages().get(0));
  }

  @Test
  public void writeFileTestOneSingleLine() {
    final FileWriter classToTest
            = SimpleConsoleFileWriterBuilder
            .create()
            .build();

    final Datapool<String> datapool1 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_1,
            TestConstants.FIRSTNAMES);
    final Datapool<String> datapool2 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_2,
            TestConstants.LASTNAMES);
    final Datapool<String> datapool3 = TestBuildHelper.buildDefaultStringDataPool(TestConstants.DATAPOOL_NAME_3,
            TestConstants.CITIES);

    final Attribute attribute1 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_1, datapool1);
    final Attribute attribute2 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_2, datapool2);
    final Attribute attribute3 = TestBuildHelper.buildAttribute(TestConstants.ATTRIBUTE_VALUE_3, datapool3);
    final LineGenerator lineGenerator
            = SimpleLineGeneratorBuilder
            .create()
            .withAttribute(attribute1)
            .withAttribute(attribute2)
            .withAttribute(attribute3)
            .withLineCount(1)
            .build();
    final SimpleFileGenerator fileGenerator
            = SimpleFileGeneratorBuilder
            .create()
            .withLineGenerator(lineGenerator)
            .build();
    final Message message = classToTest.writeFile(fileGenerator.generateFile());
    Assert.assertNotNull(message);
    Assert.assertFalse(message.isError());
    Assert.assertEquals(1, message.getMessages().size());
    Assert.assertEquals("All lines succesfully written!", message.getMessages().get(0));
  }

}
