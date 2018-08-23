package kurunsh.ventaja.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.datapool.Datapool;
import kurunsh.ventaja.exceptions.FileWriterNotFoundException;
import kurunsh.ventaja.file.File;
import kurunsh.ventaja.file.FileGenerator;
import kurunsh.ventaja.file.FileWriter;
import kurunsh.ventaja.file.SimpleConsoleFileWriterBuilder;
import kurunsh.ventaja.line.LineGenerator;
import org.apache.commons.io.IOUtils;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Set;

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

  public SimpleFileWriterCommandBuilder withFile( final File file) {
    this.instance.setFile(file);
    return this;
  }

  public SimpleFileWriterCommandBuilder withFileWriter ( final FileWriter fileWriter) {
    this.instance.setFileWriter(fileWriter);
    return this;
  }

}
