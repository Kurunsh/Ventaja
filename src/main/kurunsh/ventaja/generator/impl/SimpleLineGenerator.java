package main.kurunsh.ventaja.generator.impl;

import main.kurunsh.ventaja.generator.LineGenerator;
import main.kurunsh.ventaja.model.in.Attribute;
import main.kurunsh.ventaja.model.out.Line;

import java.util.ArrayList;
import java.util.List;

public class SimpleLineGenerator implements LineGenerator {

  private List<Attribute> attributes;

  @Override
  public void addAttribute(final Attribute attribute) {
    if ( attribute != null ) {
      if ( attributes == null ) {
        attributes = new ArrayList<Attribute>();
      }
      attributes.add(attribute);
    }
  }

  @Override
  public void addAttributeAtPosition(final Attribute attribute, final int position) {
    if ( attributes == null ) {
      attributes = new ArrayList<Attribute>();
      attributes.add(attributes.size() - 1, attribute);
    } else {
      if ( attributes.size() >= position ) {
        attributes.add(attribute);
      } else {
        attributes.add(attributes.size() - 1, attribute);
      }
    }
  }

  @Override
  public void putAttributeAtPosition(final Attribute attribute, final int position) {

  }

  @Override
  public void removeAttribute(final int position) {

  }

  @Override
  public Line writeLine() {
    return null;
  }

  @Override
  public Integer getColumnCount() {
    return attributes.size();
  }
}
