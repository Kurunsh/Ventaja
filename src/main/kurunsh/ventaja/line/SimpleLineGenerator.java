package kurunsh.ventaja.line;

import kurunsh.ventaja.attribute.Attribute;
import kurunsh.ventaja.cell.Cell;
import kurunsh.ventaja.cell.SimpleStringCellBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
class SimpleLineGenerator implements LineGenerator {

  private List<Attribute> attributes;
  private String cellSeperator;
  private int lineCount;

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

  @Override
  public int getLineCount() {
    return this.lineCount;
  }

  void setLineCount(final int lineCount) {
    this.lineCount = lineCount;
  }
}
