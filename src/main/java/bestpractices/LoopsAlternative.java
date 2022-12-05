package bestpractices;

import java.util.Arrays;
import java.util.List;

public class LoopsAlternative {

    public static final String[] FORBIDDEN_WORDS = new String[]{"Shit", "Nasty", "Bitch", "Aww"};

    public static void main(String[] args) throws HasForbiddenWordException {
        String comment = "Hey, looks awesome!";
        String username = "Mr. amigo";
        checkForbiddenWords(comment, username);
        comment = "Hey, looks nasty!";
        checkForbiddenWords(comment, username);
    }

    private static void checkForbiddenWords(String comment, String username) throws HasForbiddenWordException {
        List<String> forbiddenWords = Arrays.asList(FORBIDDEN_WORDS);
        final String finalComment = comment.toLowerCase();

        // using for loop
        for (int i = 0; i < forbiddenWords.size(); i++) {
            if (finalComment.contains(forbiddenWords.get(i).toLowerCase())) {
                throw new HasForbiddenWordException(username + " comment has forbidden words!");
            }
        }

        // using stream -> best practice
        boolean forbiddenWordsFound = Arrays.stream(FORBIDDEN_WORDS).anyMatch(fw -> finalComment.contains(fw.toLowerCase()));
        if (forbiddenWordsFound) {
            throw new HasForbiddenWordException(username + " comment has forbidden words!");
        }

        System.out.println("No forbidden words.");
    }
}

class HasForbiddenWordException extends Throwable {
    public HasForbiddenWordException(String message) {
        super(message);
    }
}
