package main.kurunsh.ventaja.model.in;

import main.kurunsh.ventaja.model.out.Cell;
import main.kurunsh.ventaja.model.out.Line;
import main.kurunsh.ventaja.model.out.File;

public interface FileInformation {

  /**
   * Returns the {@link String} representing the separator between each {@link Cell}.
   *
   * @return The separator.
   */
  String getCellSeparator();

  /**
   * Returns the {@link String} representing the separator between each {@link Line}.
   *
   * @return The separator.
   */
  String getLineSeparator();

  /**
   * Returns the {@link String} suffix of the {@link File}.
   *
   * @return The suffix (e.g. txt, csv, impex, sql).
   */
  String getFileSuffix();

}