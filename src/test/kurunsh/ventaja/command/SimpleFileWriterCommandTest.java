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

  @Test
  public void createSimpleFileWriterCommandTestWithFileWriterByName() {
    final FileWriterCommand command;
    try {
      command = SimpleFileWriterCommandBuilder
      .create()
      .withFileWriter("simpleconsolefilewriter")
      .build();
      Assert.assertNotNull(command);
      Assert.assertTrue(command.getFileWriter().getClass().getSimpleName().equals("SimpleConsoleFileWriter"));
    } catch (final FileWriterNotFoundException ignore) {
      Assert.fail();
    }
  }

  @Test
  public void executeSimpleFileWriterCommandWithoutFile() {
    final FileWriterCommand command;
    try {
      command = SimpleFileWriterCommandBuilder
              .create()
              .withFileWriter("simpleconsolefilewriter")
              .build();
      final Message message = command.execute();
      Assert.assertTrue(message.isError());
      Assert.assertEquals(ErrorMessageConstants.ERROR_WRITER_FILE_IS_NULL, message.getMessages().iterator().next());
    } catch (final FileWriterNotFoundException ignore) {
      Assert.fail();
    }
  }

  @Test(expected = FileWriterNotFoundException.class)
  public void createSimpleFileWriterCommandTestWithWrongFileWriter() throws FileWriterNotFoundException {
    final FileWriterCommand command;
    command = SimpleFileWriterCommandBuilder
            .create()
            .withFileWriter("wrongfilewriter")
            .build();
  }

}
