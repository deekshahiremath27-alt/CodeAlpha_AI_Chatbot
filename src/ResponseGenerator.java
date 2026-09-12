import java.util.Random;

public class ResponseGenerator {

    private final Random random = new Random();

    private final String[] greetings = {
            "Hello! How can I help you?",
            "Hi there! Nice to chat with you!",
            "Hey! What would you like to know?"
    };

    private final String[] unknownResponses = {
            "I'm still learning. Could you rephrase that?",
            "Interesting! Can you ask that in another way?",
            "I don't know that yet, but I'm learning!"
    };

    public String getGreeting() {
        return greetings[random.nextInt(greetings.length)];
    }

    public String getUnknownResponse() {
        return unknownResponses[
                random.nextInt(unknownResponses.length)
        ];
    }
}