package kurunsh.ventaja.file;

import helper.TestBuildHelper;
import helper.TestConstants;
import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.datapool.Datapool;
import kurunsh.ventaja.line.LineGenerator;
import kurunsh.ventaja.line.SimpleLineGeneratorBuilder;
import org.junit.Assert;
import org.junit.Test;

public class SimpleFileGeneratorTest {

  private static final String TXT_SUFFIX= ".txt";
  private static final String DEFAULT_SUFFIX= ".txt";

  @Test
  public void getFileSuffixTestNoSuffix() {
    final FileGenerator classToTest
            = SimpleFileGeneratorBuilder
            .create()
            .build();
    final String suffix = classToTest.getFileSuffix();
    Assert.assertEquals("File suffix should be " + DEFAULT_SUFFIX, DEFAULT_SUFFIX, suffix);
  }

  @Test
  public void getFileSuffixTestTxtSuffix() {
    final FileGenerator classToTest = getSimpleFileGenerator();
    final String suffix = classToTest.getFileSuffix();
    Assert.assertEquals("File suffix should be " + TXT_SUFFIX, TXT_SUFFIX, suffix);
  }

  @Test
  public void generatorGetLinesTestEmptyLines() {
    final FileGenerator classToTest = getSimpleFileGenerator();
    Assert.assertTrue(classToTest.getLineGenerators().isEmpty());
  }

  @Test
  public void createEmptyFileGeneratorTest() {
    final FileGenerator classToTest = getSimpleFileGenerator();
    final File file = classToTest.generateFile();
    Assert.assertTrue(file.getLines().isEmpty());
  }

  @Test
  public void createFileGeneratorTestOneLine() {
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
            .build();
    final FileGenerator classToTest
            = SimpleFileGeneratorBuilder
            .create()
            .withLineGenerator(lineGenerator)
            .withFileSuffix(".txt")
            .build();
    final File file = classToTest.generateFile();
    Assert.assertFalse(file.getLines().isEmpty());
  }

  private FileGenerator getSimpleFileGenerator() {
    return SimpleFileGeneratorBuilder
    .create()
    .withFileSuffix(".txt")
    .build();
  }

}
