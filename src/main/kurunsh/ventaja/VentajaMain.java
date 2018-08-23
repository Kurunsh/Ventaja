package kurunsh.ventaja;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.datapool.Datapool;
import kurunsh.ventaja.file.FileGenerator;
import kurunsh.ventaja.file.FileWriter;
import kurunsh.ventaja.line.LineGenerator;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;


public class VentajaMain {

  private static final Logger LOG = LoggerFactory.getLogger(VentajaMain.class);

  private static final String DEFAULT_PATH = "./resources/json/";
  private static final String DEFAULT_FILE_NAME = "SimpleConsoleFileWriter.json";

  /**
   * Main method for JsonParsing.
   *
   * @param args first param should be filename for target json coonfiguration
   */
  public static void main(final String[] args) {

    String fileName = DEFAULT_PATH + DEFAULT_FILE_NAME;
    if ( args != null && args.length > 0 ) {
      fileName = args[0];
    }

    final Path filePath = Paths.get(fileName);
    try {
      final InputStream stream = Files.newInputStream(filePath);
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
      IOUtils.copy(stream, writer, "UTF-8");
      final String jsonTemplate = writer.toString();

      System.out.println(jsonTemplate);
      final FileGenerator generator = objectMapper.readValue(jsonTemplate, FileGenerator.class);
      System.out.println(generator);
      System.out.println(objectMapper.writeValueAsString(generator));

    } catch (final IOException e) {
      e.printStackTrace();
    }

  }

}
