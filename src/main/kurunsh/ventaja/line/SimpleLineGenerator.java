package kurunsh.ventaja.line;

import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.cell.Cell;
import kurunsh.ventaja.cell.SimpleStringCellBuilder;

import java.util.ArrayList;
import java.util.List;

class SimpleLineGenerator implements LineGenerator {

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
      final Cell cell
              = SimpleStringCellBuilder
              .create()
              .withAttributeName(attribute.getName())
              .withAttributeValue(attribute.getValue())
              .build();
      line.addCell(cell);
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
