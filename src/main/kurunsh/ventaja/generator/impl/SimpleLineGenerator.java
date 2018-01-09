package main.kurunsh.ventaja.generator.impl;

import main.kurunsh.ventaja.builder.impl.SimpleLineBuilder;
import main.kurunsh.ventaja.generator.LineGenerator;
import main.kurunsh.ventaja.model.in.Attribute;
import main.kurunsh.ventaja.model.out.Line;

import java.util.ArrayList;
import java.util.List;

public class SimpleLineGenerator implements LineGenerator {

  private List<Attribute> attributes;
  private String cellSeperator;

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
        attributes.add(position, attribute);
      } else {
        attributes.add(attribute);
      }
    }
  }

  @Override
  public void putAttributeAtPosition(final Attribute attribute, final int position) {
    if ( attributes == null ) {
      attributes = new ArrayList<Attribute>();
      attributes.add(attributes.size() - 1, attribute);
    } else {
      if ( attributes.size() >= position ) {
        attributes.remove(position);
        attributes.add(position, attribute);
      } else {
        attributes.add(attribute);
      }
    }
  }

  @Override
  public void removeAttribute(final int position) {

  }

  @Override
  public Line createLine() {
    final Line line
            = SimpleLineBuilder
            .create()
            .withCellSeperator(this.cellSeperator)
            .build();
    for ( final Attribute attribute : this.attributes ) {
      line.addCell(attribute.getName(), attribute.getValue());
    }
    return line;
  }

  @Override
  public Integer getColumnCount() {
    return attributes.size();
  }

  @Override
  public List<Attribute> getAttributes() {
    return attributes;
  }

  public void setCellSeperator(final String cellSeperator) {
    this.cellSeperator = cellSeperator;
  }
}
