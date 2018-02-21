package kurunsh.ventaja.file;

import kurunsh.ventaja.exceptions.LineConverterException;
import kurunsh.ventaja.line.Line;
import kurunsh.ventaja.message.Message;
import kurunsh.ventaja.message.SimpleMessageBuilder;

import java.util.ArrayList;
import java.util.List;

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
    if ( file.getLines() == null || file.getLines().size() == 0 ) {
      return SimpleMessageBuilder
              .create()
              .asError()
              .withMessage("Given file contains no lines!")
              .build();
    }
    final List<String> messages = new ArrayList<>();
    int index = 0;
    for ( final Line line : file.getLines() ) {
      try {
        writeToConsole(line);
      } catch( final LineConverterException exception) {
        final String builder
                = "Line: "
                + index
                + ' '
                + exception.getLocalizedMessage();
        messages.add(builder);
      }
      index++;
    }
    if ( messages.size() > 0) {
      return SimpleMessageBuilder
              .create()
              .asError()
              .withMessages(messages)
              .build();
    }
    return SimpleMessageBuilder
            .create()
            .asSuccess()
            .withMessage("All lines succesfully written!")
            .build();
  }

  private void writeToConsole( final Line line ) throws LineConverterException {
    if ( line == null ) {
      throw new LineConverterException("Given line is null!", null);
    } else {
      try {
        System.out.print(line.getFullLineAsString());
      } catch ( final Exception exception ) {
        throw new LineConverterException(exception.getMessage(), exception.getCause());
      }
    }
  }
}
