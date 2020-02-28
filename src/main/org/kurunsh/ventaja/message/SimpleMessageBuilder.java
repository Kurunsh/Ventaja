package org.kurunsh.ventaja.message;

import org.kurunsh.ventaja.builder.Builder;

import java.util.List;

public class SimpleMessageBuilder implements Builder<SimpleMessage> {

  private final SimpleMessage instance;

  public static SimpleMessageBuilder create() {
    return new SimpleMessageBuilder();
  }

  private SimpleMessageBuilder() {
    this.instance = new SimpleMessage();
  }

  @Override
  public SimpleMessage build() {
    return this.instance;
  }

  public SimpleMessageBuilder asError() {
    this.instance.setError(Boolean.TRUE);
    return this;
  }

  public SimpleMessageBuilder asSuccess() {
    this.instance.setError(Boolean.FALSE);
    return this;
  }

  public SimpleMessageBuilder withMessage(final String message) {
    this.instance.addMessage(message);
    return this;
  }

  public SimpleMessageBuilder withMessages(final List<String> messages) {
    this.instance.setMessages(messages);
    return this;
  }
}
