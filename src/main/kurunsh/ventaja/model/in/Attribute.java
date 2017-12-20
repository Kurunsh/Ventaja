package main.kurunsh.ventaja.model.in;

/**
 *  This class contains the information for the attribute of a data set (call it a column in a relational database
 *  for example).
 */
public interface Attribute<T> {

  void setDataPool(final Datapool<T> dataPool);

  T getValue();

}
