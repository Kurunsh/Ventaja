package main.kurunsh.ventaja.generator;

import main.kurunsh.ventaja.model.out.File;

import com.sun.istack.internal.NotNull;

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
  @NotNull
  List<LineGenerator> getLineGenerators();

  /**
   * Generates the file with testdata, using the contained {@link List} of {@link LineGenerator}.
   *
   * @return The created {@link File} with testdata.
   */
  File generateFile();

}
