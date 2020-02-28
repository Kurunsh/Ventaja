package org.kurunsh.ventaja.attribute;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.kurunsh.ventaja.datapool.Datapool;

/**
 *  This class contains the information for the attribute of a data set (call it a column in a relational database
 *  for example).
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
public interface Attribute<T> {

  void setDataPool(final Datapool<T> dataPool);

  T getValue();

  String getName();

}
