package kurunsh.ventaja.command;

import kurunsh.ventaja.file.File;
import kurunsh.ventaja.file.FileWriter;
import kurunsh.ventaja.message.Message;

public class SimpleFileWriterCommand implements FileWriterCommand {

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
