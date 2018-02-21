package kurunsh.ventaja.line;

import kurunsh.ventaja.cell.Cell;
import kurunsh.ventaja.exceptions.LineConverterException;

import java.util.List;

public interface Line {

  /**
   * Returns a {@link List} of {@link Cell}s.
   *
   * @return {@link List} of {@link Cell}s.
   */
  List<Cell> getCells();

  /**
   * Returns the {@link Cell} at the given position.
   *
   * @param position The position of the {@link Cell} to be returned.
   * @throws IllegalArgumentException When the given position is null or out of bounds.
   * @return The {@link Cell} at the given position
   */
  Cell getCellAtPosition(final int position) throws IllegalArgumentException;

  /**
   * Returns the String representation for a full {@link Line}.
   *
   * @return The full Line as {@link String} representation;
   * @throws {@link LineConverterException} as Wrapper for any exeption
   *    during receiving the {@link Line} as a {@link String}.
   */
  String getFullLineAsString() throws LineConverterException;

  /**
   * Sets the {@link List} of {@link Cell} to the {@link Line}.
   *
   * @param cells The given {@link List} of {@link Cell}.
   */
  void setCells(final List<Cell> cells);

  /**
   * Adds the given {@link Cell} at the end of the cell list.
   *
   * @param cell The given {@link Cell}
   */
  void addCell(final Cell cell);
}
