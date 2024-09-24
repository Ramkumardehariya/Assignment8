import java.util.ArrayList;
import java.util.List;

// Custom Checked Exception for when feedback is not found
class FeedbackNotFoundException extends Exception {
    public FeedbackNotFoundException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception for invalid feedback content
class InvalidFeedbackContentException extends RuntimeException {
    public InvalidFeedbackContentException(String message) {
        super(message);
    }
}

// Class to represent customer feedback
class Feedback {
    private int id;
    private String content;

    // Constructor
    public Feedback(int id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

// CustomerFeedbackSystem class to manage feedback
class CustomerFeedbackSystem {
    private List<Feedback> feedbackList;
    private int nextId;

    // Constructor
    public CustomerFeedbackSystem() {
        feedbackList = new ArrayList<>();
        nextId = 1; // Start feedback IDs from 1
    }

    // Method to submit feedback
    public void submitFeedback(String content) throws InvalidFeedbackContentException {
        // Validate feedback content
        if (content == null || content.trim().isEmpty()) {
            throw new InvalidFeedbackContentException("Feedback content cannot be null or empty.");
        }

        // Simulate inappropriate content check
        if (content.toLowerCase().contains("inappropriate")) {
            throw new InvalidFeedbackContentException("Feedback contains inappropriate content.");
        }

        // Create a new feedback instance and add it to the list
        Feedback feedback = new Feedback(nextId++, content);
        feedbackList.add(feedback);
        System.out.println("Feedback submitted successfully: ID=" + feedback.getId());
    }

    // Method to retrieve feedback by ID
    public Feedback getFeedbackById(int id) throws FeedbackNotFoundException {
        // Search for feedback by ID
        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                return feedback;
            }
        }
        throw new FeedbackNotFoundException("Feedback with ID " + id + " not found.");
    }
}

public class Program10 {
    public static void main(String[] args) {
        CustomerFeedbackSystem feedbackSystem = new CustomerFeedbackSystem();

        // Submit feedback
        try {
            feedbackSystem.submitFeedback("Great service!"); // Should succeed
            feedbackSystem.submitFeedback(" "); // Should fail due to empty content
            feedbackSystem.submitFeedback("This is inappropriate."); // Should fail due to inappropriate content
        } catch (InvalidFeedbackContentException e) {
            System.out.println("Feedback error: " + e.getMessage());
            logError(e);
        }

        // Retrieve feedback
        try {
            Feedback feedback1 = feedbackSystem.getFeedbackById(1); // Should succeed
            System.out.println("Retrieved Feedback: ID=" + feedback1.getId() + ", Content='" + feedback1.getContent() + "'");

            Feedback feedback2 = feedbackSystem.getFeedbackById(2); // Should fail
        } catch (FeedbackNotFoundException e) {
            System.out.println("Feedback retrieval error: " + e.getMessage());
            logError(e);
        }
    }

    // Method to simulate logging errors for auditing purposes
    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
