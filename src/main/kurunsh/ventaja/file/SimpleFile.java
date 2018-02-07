package kurunsh.ventaja.file;

import kurunsh.ventaja.line.Line;

import java.util.ArrayList;
import java.util.List;

public class SimpleFile implements File {

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
