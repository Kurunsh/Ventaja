package kurunsh.ventaja.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.builder.Builder;
import kurunsh.ventaja.command.SimpleFileWriterCommandBuilder;
import kurunsh.ventaja.datapool.Datapool;
import kurunsh.ventaja.exceptions.FileWriterNotFoundException;
import kurunsh.ventaja.line.LineGenerator;
import org.apache.commons.io.IOUtils;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Set;

public class SimpleFileGeneratorBuilder implements Builder<SimpleFileGenerator> {

  private SimpleFileGenerator instance;

  public static SimpleFileGeneratorBuilder create() {
    return new SimpleFileGeneratorBuilder();
  }

  private SimpleFileGeneratorBuilder() {
    this.instance = new SimpleFileGenerator();
  }

  public SimpleFileGeneratorBuilder withFileSuffix(final String fileSuffix) {
    this.instance.setFileSuffix(fileSuffix);
    return this;
  }

  public SimpleFileGeneratorBuilder withLineGenerator(final LineGenerator lineGenerator) {
    this.instance.addLineGenerator(lineGenerator);
    return this;
  }

  @Override
  public SimpleFileGenerator build() {
    return this.instance;
  }

  /**
   * Checking the given name for an existing FileWriter type and returns an instance.
   *
   * @param configurationStream The stream of a configuration json.
   * @return The Builder itself.
   * @throws FileWriterNotFoundException When no {@link FileWriter} can be found by name.
   * @throws IOException If an error occurs during stream access.
   */
  public SimpleFileGeneratorBuilder withConfiguration(final InputStream configurationStream)
          throws FileWriterNotFoundException, IOException {

    final ObjectMapper objectMapper = new ObjectMapper();
    final Reflections reflections = new Reflections("kurunsh.ventaja");


    final Set<Class<? extends Datapool>> pools = reflections.getSubTypesOf(Datapool.class);

    for (Class<? extends Datapool> aClass : pools) {
      objectMapper.registerSubtypes(new NamedType(aClass, Datapool.class.getCanonicalName()));
    }

    final Set<Class<? extends Attribute>> attributes = reflections.getSubTypesOf(Attribute.class);

    for (Class<? extends Attribute> aClass : attributes) {
      objectMapper.registerSubtypes(new NamedType(aClass, Attribute.class.getCanonicalName()));
    }

    final Set<Class<? extends LineGenerator>> generators = reflections.getSubTypesOf(LineGenerator.class);

    for (Class<? extends LineGenerator> aClass : generators) {
      objectMapper.registerSubtypes(new NamedType(aClass, LineGenerator.class.getCanonicalName()));
    }

    final Set<Class<? extends FileWriter>> fileWriter = reflections.getSubTypesOf(FileWriter.class);

    for (Class<? extends FileWriter> aClass : fileWriter) {
      objectMapper.registerSubtypes(new NamedType(aClass, FileWriter.class.getCanonicalName()));
    }

    final Set<Class<? extends FileGenerator>> fileGenerator = reflections.getSubTypesOf(FileGenerator.class);

    for (Class<? extends FileGenerator> aClass : fileGenerator) {
      objectMapper.registerSubtypes(new NamedType(aClass, FileGenerator.class.getCanonicalName()));
    }

    final StringWriter writer = new StringWriter();
    IOUtils.copy(configurationStream, writer, "UTF-8");
    final String jsonTemplate = writer.toString();

    final FileGenerator generator = objectMapper.readValue(jsonTemplate, FileGenerator.class);
    this.instance = (SimpleFileGenerator) generator;
    return this;
  }

}
