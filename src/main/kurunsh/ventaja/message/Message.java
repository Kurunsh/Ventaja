package kurunsh.ventaja.message;

import java.util.List;

public interface Message {

  /**
   * Returns the {@link Boolean} value (type) of the message.
   *
   * @return {@link Boolean} value of error.
   */
  Boolean isError();

  /**
   * Returns the {@link List} of messages inside the message object.
   *
   * @return the {@link List} of messages.
   */
  List<String> getMessages();

  /**
   * Adds a message to the {@link List}.
   *
   * @param message The message to be added.
   */
  void addMessage(String message);

}
