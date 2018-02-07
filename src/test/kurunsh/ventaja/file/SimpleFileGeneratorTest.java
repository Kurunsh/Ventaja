package kurunsh.ventaja.file;

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
  public void generatorGetLinesTesEmptyLines() {
    final FileGenerator classToTest = getSimpleFileGenerator();
    Assert.assertTrue(classToTest.getLineGenerators().isEmpty());
  }

  @Test
  public void createEmptyFileTest() {
    final FileGenerator classToTest = getSimpleFileGenerator();
    final File file = classToTest.generateFile();
    Assert.assertTrue(file.getLines().isEmpty());
  }

  private FileGenerator getSimpleFileGenerator() {
    return SimpleFileGeneratorBuilder
    .create()
    .withFileSuffix(".txt")
    .build();
  }

}
