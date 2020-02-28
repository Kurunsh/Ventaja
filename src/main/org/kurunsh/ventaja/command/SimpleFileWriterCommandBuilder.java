package org.kurunsh.ventaja.command;

import org.kurunsh.ventaja.builder.Builder;
import org.kurunsh.ventaja.file.File;
import org.kurunsh.ventaja.file.FileWriter;

public class SimpleFileWriterCommandBuilder implements Builder<SimpleFileWriterCommand> {

  private SimpleFileWriterCommand instance;

  public static SimpleFileWriterCommandBuilder create() {
    return new SimpleFileWriterCommandBuilder();
  }

  private SimpleFileWriterCommandBuilder() {
    this.instance = new SimpleFileWriterCommand();
  }

  @Override
  public SimpleFileWriterCommand build() {
    return this.instance;
  }

  public SimpleFileWriterCommandBuilder withFile( final File file) {
    this.instance.setFile(file);
    return this;
  }

  public SimpleFileWriterCommandBuilder withFileWriter( final FileWriter fileWriter) {
    this.instance.setFileWriter(fileWriter);
    return this;
  }

}
