package kurunsh.ventaja.command;

import kurunsh.ventaja.file.FileWriter;
import kurunsh.ventaja.message.Message;

public interface FileWriterCommand {

  Message execute();

  FileWriter getFileWriter();

}
