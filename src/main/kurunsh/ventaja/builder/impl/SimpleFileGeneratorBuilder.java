package main.kurunsh.ventaja.builder.impl;

import main.kurunsh.ventaja.builder.Builder;
import main.kurunsh.ventaja.generator.LineGenerator;
import main.kurunsh.ventaja.generator.impl.SimpleFileGenerator;

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
