package kurunsh.ventaja.builder.impl;

import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.generator.LineGenerator;
import kurunsh.ventaja.generator.impl.SimpleFileGenerator;

public class SimpleFileGeneratorBuilder implements Builder<SimpleFileGenerator> {

  private final SimpleFileGenerator instance;

  public static SimpleFileGeneratorBuilder create() {
    return new SimpleFileGeneratorBuilder();
  }

  private SimpleFileGeneratorBuilder() {
    this.instance = new SimpleFileGenerator();
  }

  public SimpleFileGeneratorBuilder withFileSuffix(final String fileSuffix) {
    this.instance.setFileSuffix(fileSuffix);
    return this;
  }

  public SimpleFileGeneratorBuilder withLineGenerator(final LineGenerator lineGenerator) {
    this.instance.addLineGenerator(lineGenerator);
    return this;
  }

  @Override
  public SimpleFileGenerator build() {
    return this.instance;
  }
}
