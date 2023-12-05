import java.util.ArrayList;

public class MessageQueue {
    private final ArrayList<String> messages;
    private final int maxSize;

    public MessageQueue(int maxSize) {
        this.maxSize = maxSize;
        this.messages = new ArrayList<>();
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }

    public boolean isFull() {
        return messages.size() == maxSize;
    }

    public void enqueue(String message) {
        if (!isFull()) {
            messages.add(message);
        } else {
            throw new IllegalStateException("MessageQueue is full");
        }
    }

    public String dequeue() {
        if (!isEmpty()) {
            return messages.remove(0);
        } else {
            throw new IllegalStateException("MessageQueue is empty");
        }
    }

    public int size() {
        return messages.size();
    }
}
