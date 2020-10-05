package org.kurunsh.ventaja.exceptions;

public class LineConverterException extends Exception {

  public LineConverterException( final String message, final Throwable cause ) {
    super(message, cause);
  }

  public LineConverterException( final Exception exception ) {
    super(exception.getMessage(), exception.getCause());
  }

}
