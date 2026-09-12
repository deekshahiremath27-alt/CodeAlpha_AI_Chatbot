import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatbotEngine {

    private final List<String> conversationHistory =
            new ArrayList<>();

    public String getResponse(String input) {

        String message = input.toLowerCase().trim();

        String response;

        if (message.contains("hello")
                || message.contains("hi")
                || message.contains("hey")) {

            response = "Hello! How can I help you today?";

        } else if (message.contains("how are you")) {

            response = "I'm doing great! Thanks for asking.";

        } else if (message.contains("your name")
                || message.contains("who are you")) {

            response = "I'm CodeAlpha AI Chatbot, built using Java.";

        } else if (message.contains("java")) {

            response = "Java is a powerful object-oriented programming "
                    + "language used to build many types of applications.";

        } else if (message.contains("codealpha")) {

            response = "CodeAlpha helps students gain practical "
                    + "programming and internship experience.";

        } else if (message.contains("time")) {

            response = "The current time is "
                    + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("HH:mm:ss"));

        } else if (message.contains("date")) {

            response = "Today's date is "
                    + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        } else if (message.contains("help")) {

            response = "You can ask me about Java, CodeAlpha, "
                    + "the date, time, or general questions.";

        } else if (message.contains("thank")) {

            response = "You're welcome! 😊";

        } else if (message.contains("bye")
                || message.contains("exit")
                || message.contains("quit")) {

            response = "Goodbye! Have a great day!";

        } else {

            response = "I'm still learning. Could you please "
                    + "rephrase your question?";
        }

        conversationHistory.add(
                "You: " + input
        );

        conversationHistory.add(
                "Bot: " + response
        );

        return response;
    }

    public void showHistory() {

        System.out.println(
                "\n========== CHAT HISTORY =========="
        );

        if (conversationHistory.isEmpty()) {

            System.out.println(
                    "No conversation history available."
            );

            return;
        }

        for (String message : conversationHistory) {
            System.out.println(message);
        }
    }

    public void clearHistory() {

        conversationHistory.clear();

        System.out.println(
                "Conversation history cleared."
        );
    }
}