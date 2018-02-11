package kurunsh.ventaja.message;

import java.util.ArrayList;
import java.util.List;

class SimpleMessage implements Message{

  private Boolean error;
  private List<String> messages;

  @Override
  public Boolean isError() {
    return this.error;
  }

  SimpleMessage() {
    this.messages = new ArrayList<>();
  }

  @Override
  public List<String> getMessages() {
    return this.messages;
  }

  public void setError(final Boolean error) {
    this.error = error;
  }

  public void setMessages(final List<String> messages) {
    this.messages = messages;
  }

  @Override
  public void addMessage(final String message) {
    this.messages.add(message);
  }
}
