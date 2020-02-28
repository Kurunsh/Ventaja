package org.kurunsh.ventaja.command;

import org.kurunsh.ventaja.file.FileWriter;
import org.kurunsh.ventaja.message.Message;

public interface FileWriterCommand {

  Message execute();

  FileWriter getFileWriter();

}
