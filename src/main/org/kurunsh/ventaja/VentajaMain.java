package org.kurunsh.ventaja;

import org.kurunsh.ventaja.command.FileWriterCommand;
import org.kurunsh.ventaja.command.SimpleFileWriterCommandBuilder;
import org.kurunsh.ventaja.file.File;
import org.kurunsh.ventaja.file.FileGenerator;
import org.kurunsh.ventaja.file.FileWriter;
import org.kurunsh.ventaja.file.SimpleConsoleFileWriterBuilder;
import org.kurunsh.ventaja.file.SimpleFileGeneratorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class VentajaMain {

  private static final Logger LOG = LoggerFactory.getLogger(VentajaMain.class);

  private static final String DEFAULT_PATH = "./resources/json/";
  private static final String DEFAULT_FILE_NAME = "SimpleConsoleFileWriter.json";

  /**
   * Main method for JsonParsing.
   *
   * @param args first param should be filename for target json configuration
   */
  public static void main(final String[] args) {

    String fileName = DEFAULT_PATH + DEFAULT_FILE_NAME;
    if ( args != null && args.length > 0 ) {
      fileName = args[0];
    }

    final Path filePath = Paths.get(fileName);
    try ( final InputStream stream = Files.newInputStream(filePath) ) {
      final FileGenerator generator = SimpleFileGeneratorBuilder.create().withConfiguration(stream).build();
      final File file = generator.generateFile();
      final FileWriter writer = SimpleConsoleFileWriterBuilder.create().build();
      final FileWriterCommand command = SimpleFileWriterCommandBuilder.create()
              .withFile(file)
              .withFileWriter(writer)
              .build();
      command.execute();

    } catch (final IOException exception) {
      LOG.error("Error during File access / generation: ", exception);
    }
  }

}