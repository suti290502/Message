import java.util.ArrayList;

public class MessageProcessor {
    private final ArrayList<String> messages;

    public MessageProcessor() {
        this.messages = new ArrayList<>();
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }

    public void push(String message) {
        messages.add(message);
    }

    public String pop() {
        if (!isEmpty()) {
            int lastIndex = messages.size() - 1;
            return messages.remove(lastIndex);
        } else {
            throw new IllegalStateException("MessageProcessor is empty");
        }
    }

    public String processMessage(String message) {
        if (isValidMessage(message)) {
            push(message);
            return pop();
        } else {
            return "Error: Invalid Message";
        }
    }

    public boolean isValidMessage(String message) {
        // Implement your message validation logic here
        return message.length() <= 200;
    }
}
