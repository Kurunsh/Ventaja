package main.kurunsh.ventaja.model.out;

public interface Cell<T> {

  /**
   * Returns the {@link String} representation of the headline of the {@link Cell}.
   *
   * @return Headline of the {@link Cell};
   */
  String getHeadline();

  /**
   * Returns the value of the {@link Cell} as its {@link Object}.
   *
   * @return Value of the {@link Cell}.
   */
  T getValue();

  /**
   * Returns the value of the {@link Cell} as a String. Should be used for creating {@link File}s.
   *
   * @return Value of the {@link Cell} as String
   */
  String getValueAsString();

}
