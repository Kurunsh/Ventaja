package org.kurunsh.ventaja.file;

import org.kurunsh.ventaja.line.Line;
import org.kurunsh.ventaja.cell.Cell;

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
