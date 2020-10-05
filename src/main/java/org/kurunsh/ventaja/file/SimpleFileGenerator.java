package org.kurunsh.ventaja.file;

import org.kurunsh.ventaja.line.LineGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
class SimpleFileGenerator implements FileGenerator {

  private static final String DEFAULT_FILE_SUFFIX = ".txt";

  private String fileSuffix;

  private final List<LineGenerator> lineGenerator;

  SimpleFileGenerator() {
    this.lineGenerator = new ArrayList<>();
  }

  @Override
  public void addLineGenerator(final LineGenerator generator) {
    this.lineGenerator.add(generator);
  }

  @Override
  public List<LineGenerator> getLineGenerator() {
    return lineGenerator;
  }

  @Override
  public File generateFile() {
    final File simpleFile = new SimpleFile();
    for ( final LineGenerator lineGen : this.lineGenerator) {
      for ( int count = 0 ; count < lineGen.getLineCount() ; count++ ) {
        simpleFile.addLine(lineGen.createLine());
      }
    }
    return simpleFile;
  }

  @Override
  public String getFileSuffix() {
    if ( this.fileSuffix == null
            || "".equals(this.fileSuffix)) {
      return DEFAULT_FILE_SUFFIX;
    }
    return fileSuffix;
  }

  void setFileSuffix(final String fileSuffix) {
    this.fileSuffix = fileSuffix;
  }


}
