package main.kurunsh.ventaja.model.out.impl;

import main.kurunsh.ventaja.model.out.Cell;
import main.kurunsh.ventaja.model.out.Line;

import java.util.ArrayList;
import java.util.List;

public class SimpleLine implements Line {

  private List<Cell> cells;

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
    return null;
  }

  @Override
  public void setCells(final List<Cell> cell) {

  }

  @Override
  public void addCell(final String name, final Object value) {
    if ( this.cells == null ) {
      this.cells = new ArrayList<Cell>();
    }
    this.cells.add(new SimpleStringCell(name, String.valueOf(value)));
  }
}
