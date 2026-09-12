import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chatbot {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> conversationHistory = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("          CODEALPHA AI CHATBOT");
        System.out.println("======================================");
        System.out.println("Bot: Hello! I'm your Java AI Chatbot.");
        System.out.println("Bot: Ask me something or type 'help'.");

        while (true) {

            System.out.print("\nYou: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Bot: Please type something.");
                continue;
            }

            String response = generateResponse(input);

            conversationHistory.add(
                    "You: " + input
            );

            conversationHistory.add(
                    "Bot: " + response
            );

            System.out.println("Bot: " + response);

            if (input.equalsIgnoreCase("bye")
                    || input.equalsIgnoreCase("exit")
                    || input.equalsIgnoreCase("quit")) {
                break;
            }
        }

        scanner.close();
    }

    private static String generateResponse(String input) {

        String message = input.toLowerCase();

        if (message.contains("hello")
                || message.contains("hi")
                || message.contains("hey")) {

            return "Hello! Nice to meet you. How can I help you?";
        }

        if (message.contains("how are you")) {

            return "I'm doing great! Thanks for asking.";
        }

        if (message.contains("your name")
                || message.contains("who are you")) {

            return "I'm CodeAlpha AI Chatbot, built using Java.";
        }

        if (message.contains("java")) {

            return "Java is an object-oriented programming language "
                    + "widely used for application development.";
        }

        if (message.contains("codealpha")) {

            return "CodeAlpha provides internship opportunities "
                    + "to help students gain practical programming experience.";
        }

        if (message.contains("time")) {

            return "The current time is "
                    + LocalDateTime.now()
                    .format(
                            DateTimeFormatter.ofPattern(
                                    "HH:mm:ss"
                            )
                    );
        }

        if (message.contains("date")) {

            return "Today's date is "
                    + LocalDateTime.now()
                    .format(
                            DateTimeFormatter.ofPattern(
                                    "dd-MM-yyyy"
                            )
                    );
        }

        if (message.contains("help")) {

            return "You can ask me about Java, CodeAlpha, "
                    + "the current date/time, or just chat with me.";
        }

        if (message.contains("thank")) {

            return "You're welcome! 😊";
        }

        if (message.contains("bye")
                || message.contains("exit")
                || message.contains("quit")) {

            return "Goodbye! Have a great day!";
        }

        return "I'm still learning. Could you please rephrase that?";
    }
}import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ChatbotEngine chatbot = new ChatbotEngine();

        System.out.println("======================================");
        System.out.println("          CODEALPHA AI CHATBOT");
        System.out.println("======================================");

        System.out.println("Bot: Hello! I'm your Java AI Chatbot.");
        System.out.println("Bot: Type 'help' to see what I can do.");
        System.out.println("Bot: Type 'history' to view our conversation.");
        System.out.println("Bot: Type 'clear' to clear the history.");
        System.out.println("Bot: Type 'bye' to exit.");

        while (true) {

            System.out.print("\nYou: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Bot: Please type something.");
                continue;
            }

            if (input.equalsIgnoreCase("history")) {
                chatbot.showHistory();
                continue;
            }

            if (input.equalsIgnoreCase("clear")) {
                chatbot.clearHistory();
                continue;
            }

            String response = chatbot.getResponse(input);

            System.out.println("Bot: " + response);

            if (input.equalsIgnoreCase("bye")
                    || input.equalsIgnoreCase("exit")
                    || input.equalsIgnoreCase("quit")) {
                break;
            }
        }

        System.out.println("\nBot: Thanks for chatting! Goodbye!");

        scanner.close();
    }
}