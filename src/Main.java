import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create instances of MessageQueue and MessageProcessor
        int maxQueueSize = 10;  // You can adjust the maximum queue size as needed
        MessageQueue messageQueue = new MessageQueue(maxQueueSize);
        MessageProcessor messageProcessor = new MessageProcessor();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of messages to input
        System.out.print("Enter the number of messages to input: ");
        int numberOfMessages = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Simulate input messages
        for (int i = 0; i < numberOfMessages; i++) {
            System.out.println("Enter Message " + (i + 1) + " (max 200 characters): ");
            String inputMessage = scanner.nextLine();

            if (inputMessage.length() <= 200) {
                messageQueue.enqueue(inputMessage);
            } else {
                System.out.println("Error: Message exceeds maximum length of 200 characters. Please enter again.");
                i--; // Decrement i to repeat the current input iteration
            }
        }

        // Process and display messages
        System.out.println("\nProcessed Messages:");
        while (!messageQueue.isEmpty()) {
            String currentMessage = messageQueue.dequeue();
            String processedMessage = messageProcessor.processMessage(currentMessage);
            System.out.println(processedMessage);
        }

        // Close the scanner
        scanner.close();
    }
}
