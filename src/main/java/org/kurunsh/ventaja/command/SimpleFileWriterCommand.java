package org.kurunsh.ventaja.command;

import org.kurunsh.ventaja.file.File;
import org.kurunsh.ventaja.file.FileWriter;
import org.kurunsh.ventaja.message.Message;

class SimpleFileWriterCommand implements FileWriterCommand {

  private File file;
  private FileWriter fileWriter;

  @Override
  public Message execute() {
    return this.fileWriter.writeFile(file);
  }

  @Override
  public FileWriter getFileWriter() {
    return this.fileWriter;
  }


  void setFileWriter(final FileWriter fileWriter) {
    this.fileWriter = fileWriter;
  }

  void setFile(final File file) {
    this.file = file;
  }
}
