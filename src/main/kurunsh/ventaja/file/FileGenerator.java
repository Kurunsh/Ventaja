package kurunsh.ventaja.file;

import kurunsh.ventaja.line.LineGenerator;

import java.util.List;

public interface FileGenerator {

  /**
   * Adding a new {@link LineGenerator} to the {@link FileGenerator}
   *
   * @param generator The LineGenerator to be added.
   */
  void addLineGenerator(final LineGenerator generator);

  /**
   * Returns the List of {@link LineGenerator} this {@link FileGenerator}contains
   *
   * @return a {@link List} of {@link LineGenerator}
   */
  List<LineGenerator> getLineGenerators();

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
