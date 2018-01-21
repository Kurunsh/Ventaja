package kurunsh.ventaja.generator;

import java.util.List;

public interface HeadlineGenerator extends LineGenerator {

  /**
   * Returns the {@link List} of {@link LineGenerator}, subordinated to this Headline
   *
   * @return {@link List} of {@link LineGenerator}
   */
  List<LineGenerator> getSubordinatedLineGenerators();

}
