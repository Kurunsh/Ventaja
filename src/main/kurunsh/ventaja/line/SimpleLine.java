package kurunsh.ventaja.line;

import kurunsh.ventaja.cell.Cell;

import java.util.ArrayList;
import java.util.List;

class SimpleLine implements Line {

  private static final String DEFAULT_CELL_SEPERATOR = " ";

  private List<Cell> cells;
  private String cellSeperator;

  @Override
  public List<Cell> getCells() {
    return null;
  }

  @Override
  public Cell getCellAtPosition(final int position) throws IllegalArgumentException {

    return null;
  }

  @Override
  public String getFullLineAsString() {
    final StringBuilder builder = new StringBuilder();
    for ( final Cell cell : cells ) {
      builder.append(cell.getValueAsString());
      if ( this.cellSeperator == null || "".equals(this.cellSeperator) ) {
        builder.append(DEFAULT_CELL_SEPERATOR);
      } else {
        builder.append(this.cellSeperator);
      }
    }
    return builder.toString();
  }

  @Override
  public void setCells(final List<Cell> cell) {

  }

  @Override
  public void addCell(final Cell cell) {
    if ( this.cells == null ) {
      this.cells = new ArrayList<Cell>();
    }
    this.cells.add(cell);
  }

  public void setCellSeperator(final String cellSeperator) {
    this.cellSeperator = cellSeperator;
  }
}
