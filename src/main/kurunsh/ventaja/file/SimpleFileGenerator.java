package kurunsh.ventaja.file;

import kurunsh.ventaja.line.LineGenerator;

import java.util.ArrayList;
import java.util.List;

class SimpleFileGenerator implements FileGenerator {

  private static final String DEFAULT_FILE_SUFFIX = ".txt";

  private String fileSuffix;

  private List<LineGenerator> lines;

  public SimpleFileGenerator() {
    this.lines = new ArrayList<>();
  }

  @Override
  public void addLineGenerator(final LineGenerator generator) {
    this.lines.add(generator);
  }

  @Override
  public List<LineGenerator> getLineGenerators() {
    return lines;
  }

  @Override
  public File generateFile() {
    final File simpleFile = new SimpleFile();
    for ( final LineGenerator lineGenerator : this.lines ) {
      simpleFile.addLine(lineGenerator.createLine());
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

  public void setFileSuffix(final String fileSuffix) {
    this.fileSuffix = fileSuffix;
  }
}
