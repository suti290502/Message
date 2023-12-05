public class MessageValidator {
    public boolean isValid(String message) {
        return message != null && !message.isEmpty() && message.length() <= 200;
    }
}
