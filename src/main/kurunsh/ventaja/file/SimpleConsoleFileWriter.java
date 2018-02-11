package kurunsh.ventaja.file;

import kurunsh.ventaja.message.Message;
import kurunsh.ventaja.message.SimpleMessageBuilder;

class SimpleConsoleFileWriter implements FileWriter {

  @Override
  public Message writeFile(final File file) {
    if ( file == null ) {
      return SimpleMessageBuilder
              .create()
              .asError()
              .withMessage("Given file is null!")
              .build();
    }
    return null;
  }
}
