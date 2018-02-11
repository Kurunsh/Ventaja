package kurunsh.ventaja.file;

import kurunsh.ventaja.message.Message;

public interface FileWriter {

  /**
   * Writes the {@link File}.
   *
   * @param file The {@link File} that should be written.
   */
  Message writeFile(final File file);

}
