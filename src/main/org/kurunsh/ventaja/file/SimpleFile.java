package org.kurunsh.ventaja.file;

import org.kurunsh.ventaja.line.Line;

import java.util.ArrayList;
import java.util.List;

class SimpleFile implements File {

  private List<Line> lines;

  SimpleFile() {
    this.lines = new ArrayList<>();
  }

  @Override
  public List<Line> getLines() {
    return this.lines;
  }

  @Override
  public void addLine(final Line line) {
    lines.add(line);
  }
}
