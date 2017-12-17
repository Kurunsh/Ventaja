package main.kurunsh.ventaja.generator.impl;

import main.kurunsh.ventaja.builder.impl.SimpleFileGeneratorBuilder;
import org.junit.Assert;
import org.junit.Test;

public class SimpleFileGeneratorTest {

  private static final String SUFFIX = ".txt";

  @Test
  public void getFileSuffixTest_noSuffix() {
    final SimpleFileGenerator classToTest
            = SimpleFileGeneratorBuilder
            .create()
            .build();
    final String suffix = classToTest.getFileSuffix();
    Assert.assertEquals("File suffix should be " + SUFFIX, SUFFIX, suffix);
  }

  @Test
  public void getFileSuffixTest_txtSuffix() {
    final SimpleFileGenerator classToTest
            = SimpleFileGeneratorBuilder
            .create()
            .withFileSuffix(".txt")
            .build();
    final String suffix = classToTest.getFileSuffix();
    Assert.assertEquals("File suffix should be " + SUFFIX, SUFFIX, suffix);
  }

}
