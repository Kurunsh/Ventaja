package kurunsh.ventaja.file;

import kurunsh.ventaja.cell.Cell;
import kurunsh.ventaja.line.Line;

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
