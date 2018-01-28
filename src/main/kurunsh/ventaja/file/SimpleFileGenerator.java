package kurunsh.ventaja.file;

import kurunsh.ventaja.line.LineGenerator;

import java.util.List;

class SimpleFileGenerator implements FileGenerator {

  private static final String DEFAULT_FILE_SUFFIX = ".txt";

  private String fileSuffix;

  @Override
  public void addLineGenerator(final LineGenerator generator) {

  }

  @Override
  public List<LineGenerator> getLineGenerators() {
    return null;
  }

  @Override
  public File generateFile() {
    return null;
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
