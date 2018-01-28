package kurunsh.ventaja.file;

import kurunsh.ventaja.line.Line;

import java.util.List;

public interface File {

  /**
   * Returns the {@link List} of {@link Line}s.
   *
   * @return The {@link Line}s.
   */
  List<Line> getLines();

}
