public class IntentDetector {

    public Intent detectIntent(String input) {

        String message = input.toLowerCase().trim();

        if (message.contains("hello")
                || message.contains("hi")
                || message.contains("hey")) {
            return Intent.GREETING;
        }

        if (message.contains("bye")
                || message.contains("exit")
                || message.contains("quit")) {
            return Intent.FAREWELL;
        }

        if (message.contains("java")
                || message.contains("jdk")
                || message.contains("programming")) {
            return Intent.JAVA;
        }

        if (message.contains("codealpha")
                || message.contains("internship")) {
            return Intent.CODEALPHA;
        }

        if (message.contains("time")) {
            return Intent.TIME;
        }

        if (message.contains("date")
                || message.contains("today")) {
            return Intent.DATE;
        }

        if (message.contains("help")
                || message.contains("what can you do")) {
            return Intent.HELP;
        }

        if (message.contains("thank")
                || message.contains("thanks")) {
            return Intent.THANKS;
        }

        return Intent.UNKNOWN;
    }
}