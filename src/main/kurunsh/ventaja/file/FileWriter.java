package kurunsh.ventaja.file;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kurunsh.ventaja.message.Message;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
public interface FileWriter {

  /**
   * Writes the {@link File}.
   *
   * @param file The {@link File} that should be written.
   */
  Message writeFile(final File file);

}
