package kurunsh.ventaja.file;

import kurunsh.ventaja.message.Message;
import org.junit.Assert;
import org.junit.Test;

public class SimpleConsoleFileWriterTest {

  @Test
  public void writeFileTestNoFile() {
    final FileWriter classToTest
            = SimpleConsoleFileWriterBuilder
            .create()
            .build();
    final Message message = classToTest.writeFile(null);
    Assert.assertNotNull(message);
    Assert.assertEquals(1, message.getMessages().size());
    Assert.assertEquals("Given file is null!", message.getMessages().get(0));
  }

}
