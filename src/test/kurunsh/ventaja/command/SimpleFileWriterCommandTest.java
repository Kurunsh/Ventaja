package kurunsh.ventaja.command;

import kurunsh.ventaja.exceptions.FileWriterNotFoundException;
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

  @Test(expected = FileWriterNotFoundException.class)
  public void createSimpleFileWriterCommandTestWithWrongFileWriter() throws FileWriterNotFoundException {
    final FileWriterCommand command;
    command = SimpleFileWriterCommandBuilder
            .create()
            .withFileWriter("wrongfilewriter")
            .build();
  }

}
