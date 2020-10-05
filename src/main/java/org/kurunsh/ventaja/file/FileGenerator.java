package org.kurunsh.ventaja.file;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.kurunsh.ventaja.line.LineGenerator;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
public interface FileGenerator {

  /**
   * Adding a new {@link LineGenerator} to the {@link FileGenerator}.
   *
   * @param generator The LineGenerator to be added.
   */
  void addLineGenerator(final LineGenerator generator);

  /**
   * Returns the List of {@link LineGenerator} this {@link FileGenerator} contains.
   *
   * @return a {@link List} of {@link LineGenerator}
   */
  List<LineGenerator> getLineGenerator();

  /**
   * Generates the file with testdata, using the contained {@link List} of {@link LineGenerator}.
   *
   * @return The created {@link File} with testdata.
   */
  File generateFile();

  /**
   * Getter for the file suffix used by the Generator.
   *
   * @return The used fileSuffix.
   */
  String getFileSuffix();

}
