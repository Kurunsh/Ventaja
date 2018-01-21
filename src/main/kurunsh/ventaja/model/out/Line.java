package kurunsh.ventaja.model.out;

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
   *
   *
   * @return The full Line as {@link String} representation;
   */
  String getFullLineAsString();

  void setCells(final List<Cell> cells);

  void addCell(String name, Object value);
}
