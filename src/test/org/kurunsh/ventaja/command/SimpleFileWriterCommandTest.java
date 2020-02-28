package org.kurunsh.ventaja.command;

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
