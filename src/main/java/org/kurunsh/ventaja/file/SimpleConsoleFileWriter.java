package org.kurunsh.ventaja.file;

import org.kurunsh.ventaja.constants.ErrorMessageConstants;
import org.kurunsh.ventaja.exceptions.LineConverterException;
import org.kurunsh.ventaja.line.Line;
import org.kurunsh.ventaja.message.Message;
import org.kurunsh.ventaja.message.SimpleMessageBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
class SimpleConsoleFileWriter implements FileWriter {

  @Override
  public Message writeFile(final File file) {
    if ( file == null ) {
      return SimpleMessageBuilder
              .create()
              .asError()
              .withMessage(ErrorMessageConstants.ERROR_WRITER_FILE_IS_NULL)
              .build();
    }
    if ( file.getLines() == null || file.getLines().isEmpty() ) {
      return SimpleMessageBuilder
              .create()
              .asError()
              .withMessage(ErrorMessageConstants.ERROR_WRITER_FILE_CONTAINS_NO_LINES)
              .build();
    }
    final List<String> messages = new ArrayList<>();
    int index = 0;
    for ( final Line line : file.getLines() ) {
      try {
        writeToConsole(line);
      } catch ( final LineConverterException exception) {
        final String builder
                = "Line: "
                + index
                + ' '
                + exception.getLocalizedMessage();
        messages.add(builder);
      }
      index++;
    }
    if ( !messages.isEmpty()) {
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
        throw new LineConverterException(exception);
      }
    }
  }
}
