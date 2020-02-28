package org.kurunsh.ventaja.file;

import org.kurunsh.ventaja.builder.Builder;

public class SimpleConsoleFileWriterBuilder implements Builder<SimpleConsoleFileWriter> {

  private final SimpleConsoleFileWriter instance;

  public static SimpleConsoleFileWriterBuilder create() {
    return new SimpleConsoleFileWriterBuilder();
  }

  private SimpleConsoleFileWriterBuilder() {
    this.instance = new SimpleConsoleFileWriter();
  }

  @Override
  public SimpleConsoleFileWriter build() {
    return this.instance;
  }
}
