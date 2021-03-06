package kurunsh.ventaja.datapool;

import java.util.List;

/**
 * This class contains data, that can be assigned to an attribute. For example a bunch of firstnames, to fill up an
 * {@link}Attribute representing the first names of customers.
 */
public interface Datapool<T> {

  public String getName();

  public List<T> getValues();

  T getRandomValue();
}
