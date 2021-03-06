package kurunsh.ventaja.line;

import kurunsh.ventaja.attribute.Attribute;

import java.util.List;

public interface LineGenerator {

  /**
   * Adds an {@link Attribute} to the {@link LineGenerator}.
   *
   * @param attribute The {@link Attribute} to be added.
   */
  void addAttribute(final Attribute attribute);

  /**
   * Adds an {@link Attribute} to the {@link LineGenerator} at the given position.
   * If the position is already given to another {@link Attribute}, the new {@link Attribute} is add on the given
   * position and the following {@link Attribute}s are moved one position up.
   *
   * @param attribute The {@link Attribute} to be added.
   * @param position The position, where the attribute is added.
   */
  void addAttributeAtPosition(final Attribute attribute, final int position);

  /**
   * Adds an {@link Attribute} to the {@link LineGenerator} at the given position.
   * If the position is already given to another {@link Attribute}, this {@link Attribute} is overwritten.
   *
   * @param attribute The {@link Attribute} to be added.
   * @param position The position, where the attribute is added.
   */
  void putAttributeAtPosition(final Attribute attribute, final int position);

  /**
   * Removes the {@link Attribute} on the given position. The following {@link Attribute}s are moved forward in
   * position, so no position is left with null.
   *
   * @param position The position, where the {@link Attribute} should be removed.
   */
  void removeAttribute(final int position);

  /**
   * Writes the {@link Line}, using the {@link List} of Attributes.
   *
   * @return The created line.
   */
  Line createLine();

  /**
   * Returns the number of {@link Attribute} located inside the LineGenerator.
   *
   * @return The count of {@link Attribute}s
   */
  Integer getColumnCount();

  /**
   * Returns the list of attributes.
   */
  List<Attribute> getAttributes();

  /**
   * Returns the cellSeperator for the {@link Line}.
   *
   * @param cellSeperator The cellSeperator.
   */
  void setCellSeperator(final String cellSeperator);

}
