package kurunsh.ventaja.command;

import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.exceptions.FileWriterNotFoundException;
import kurunsh.ventaja.file.File;
import kurunsh.ventaja.file.FileWriter;
import kurunsh.ventaja.file.SimpleConsoleFileWriterBuilder;

public class SimpleFileWriterCommandBuilder implements Builder<SimpleFileWriterCommand> {

  private SimpleFileWriterCommand instance;

  public static SimpleFileWriterCommandBuilder create() {
    return new SimpleFileWriterCommandBuilder();
  }

  private SimpleFileWriterCommandBuilder() {
    this.instance = new SimpleFileWriterCommand();
  }

  @Override
  public SimpleFileWriterCommand build() {
    return this.instance;
  }

  /**
   * Checking the given name for an existing FileWriter type and returns an instance.
   *
   * @param fileWriterName The name of the fileWriter that should be used.
   * @return The Builder itself.
   * @throws FileWriterNotFoundException When no {@link FileWriter} can be found by name.
   */
  public SimpleFileWriterCommandBuilder withFileWriter( final String fileWriterName ) throws FileWriterNotFoundException {
    // TODO: Replace by GUICE
    switch (fileWriterName.toLowerCase()) {
      case "simpleconsolefilewriter" :
        final FileWriter fileWriter = SimpleConsoleFileWriterBuilder.create().build();
        this.instance.setFileWriter(fileWriter);
        break;
      default:
        throw new FileWriterNotFoundException("The FileWriter with the name " + fileWriterName + " could not be found!");
    }
    return this;
  }

  public SimpleFileWriterCommandBuilder withFile( final File file) {
    this.instance.setFile(file);
    return this;
  }

}
