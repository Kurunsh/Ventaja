package org.kurunsh.ventaja.line;

import org.kurunsh.ventaja.cell.Cell;

import java.util.ArrayList;
import java.util.List;

class SimpleLine implements Line {

  private static final String DEFAULT_CELL_SEPERATOR = " ";

  private List<Cell> cells = new ArrayList<>();
  private String cellSeperator;

  @Override
  public List<Cell> getCells() {
    return cells;
  }

  @Override
  public Cell getCellAtPosition(final int position)  {
    if ( position > cells.size() ) {
      return cells.get(cells.size() - 1);
    }
    return cells.get(position);
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
    builder.append(System.lineSeparator());
    return builder.toString();
  }

  @Override
  public void setCells(final List<Cell> cells) {
    this.cells = cells;
  }

  @Override
  public void addCell(final Cell cell) {
    if ( this.cells == null ) {
      this.cells = new ArrayList<>();
    }
    this.cells.add(cell);
  }

  public void setCellSeperator(final String cellSeperator) {
    this.cellSeperator = cellSeperator;
  }
}
