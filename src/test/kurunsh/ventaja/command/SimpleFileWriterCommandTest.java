package kurunsh.ventaja.command;

import kurunsh.ventaja.constants.ErrorMessageConstants;
import kurunsh.ventaja.exceptions.FileWriterNotFoundException;
import kurunsh.ventaja.message.Message;
import org.junit.Assert;
import org.junit.Test;

public class SimpleFileWriterCommandTest {

  @Test
  public void createSimpleFileWriterCommandTest() {
    final FileWriterCommand command
            = SimpleFileWriterCommandBuilder
            .create()
            .build();
    Assert.assertNotNull(command);
  }
}
