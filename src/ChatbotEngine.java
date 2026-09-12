import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatbotEngine {

    private final IntentDetector detector;
    private final ResponseGenerator responseGenerator;
    private final List<String> conversationHistory;

    public ChatbotEngine() {
        detector = new IntentDetector();
        responseGenerator = new ResponseGenerator();
        conversationHistory = new ArrayList<>();
    }

    public String getResponse(String input) {

        Intent intent = detector.detectIntent(input);

        String response;

        switch (intent) {

            case GREETING:
                response = responseGenerator.getGreeting();
                break;

            case FAREWELL:
                response = "Goodbye! Have a great day!";
                break;

            case JAVA:
                response = "Java is a powerful object-oriented "
                        + "programming language used to build "
                        + "many types of applications.";
                break;

            case CODEALPHA:
                response = "CodeAlpha helps students gain "
                        + "practical programming and internship "
                        + "experience.";
                break;

            case TIME:
                response = "The current time is "
                        + LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("HH:mm:ss"));
                break;

            case DATE:
                response = "Today's date is "
                        + LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;

            case HELP:
                response = "You can ask me about Java, "
                        + "CodeAlpha, the date, time, "
                        + "or general questions.";
                break;

            case THANKS:
                response = "You're welcome! 😊";
                break;

            default:
                response = responseGenerator.getUnknownResponse();
                break;
        }

        conversationHistory.add("You: " + input);
        conversationHistory.add("Bot: " + response);

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