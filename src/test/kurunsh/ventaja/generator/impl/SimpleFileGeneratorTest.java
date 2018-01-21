package kurunsh.ventaja.generator.impl;

import kurunsh.ventaja.builder.impl.SimpleFileGeneratorBuilder;
import kurunsh.ventaja.generator.impl.SimpleFileGenerator;
import org.junit.Assert;
import org.junit.Test;

public class SimpleFileGeneratorTest {

  private static final String SUFFIX = ".txt";

  @Test
  public void getFileSuffixTestNoSuffix() {
    final SimpleFileGenerator classToTest
            = SimpleFileGeneratorBuilder
            .create()
            .build();
    final String suffix = classToTest.getFileSuffix();
    Assert.assertEquals("File suffix should be " + SUFFIX, SUFFIX, suffix);
  }

  @Test
  public void getFileSuffixTestTxtSuffix() {
    final SimpleFileGenerator classToTest
            = SimpleFileGeneratorBuilder
            .create()
            .withFileSuffix(".txt")
            .build();
    final String suffix = classToTest.getFileSuffix();
    Assert.assertEquals("File suffix should be " + SUFFIX, SUFFIX, suffix);
  }

}
