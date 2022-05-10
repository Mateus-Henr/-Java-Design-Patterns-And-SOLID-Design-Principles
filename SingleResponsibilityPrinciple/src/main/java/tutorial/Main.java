package tutorial;

/*  Single Responsibility Principle

     This represents the first principle in tbe acronym SOLID.

    What this principle tells us
    THERE SHOULD NEVER BE MORE THAN ONE REASON FOR A CLASS TOP CHANGE.

    Meaning
    Since we are working around the Single Responsibility principle, it means that
    a class has to:
        • Be focused.
        • Single functionality.
        • Addresses a specific concern.

    Example where this principle should be applied to
    • One example brought up by the video, it when a single class is responsible to
      send a message to a server, in other words, all the necessary code to connect to
      the server, set the message up is handled by a single class.
    • When analysing this, we can notice that we would have plenty of reasons to
      modify this class, reasons such as: changing the file format (JSON -> XML), updating
      an HTTP connection, server authentication, etc. These are some of the many reasons why this pattern should be
      applied.

    In conclusion
    • According to the number of responsibilities that we have, we have to have the same number of classes in order to
      keep the multiple responsibilities separated from each other.
    • This is important for keeping the code maintainable for future changes.
 */

import java.io.IOException;

// Main class to test.
public class Main
{
    // A valid USER JSON String.
    private static final String VALID_USER_JSON = "{\"name\": \"Randy\", \"email\": \"randy@email.com\", \"address\":\"110 Sugar lane\"}";

    // Invalid USER JSON String - email format wrong.
    private static final String INVALID_USER_JSON = "{\"name\": \"Sam\", \"email\": \"sam@email\", \"address\":\"111 Sugar lane\"}";

    public static void main(String[] args) throws IOException
    {
        UserController controller = new UserController();


        // Check with valid JSON.
        String response = controller.createUser(VALID_USER_JSON);

        if (!response.equalsIgnoreCase("SUCCESS"))
        {
            System.err.println("Failed");
        }

        System.out.println("Valid JSON received response: " + response);


        // Check with invalid JSON.
        response = controller.createUser(INVALID_USER_JSON);

        if (!response.equalsIgnoreCase("ERROR"))
        {
            System.err.println("Failed");
        }

        System.out.println("Invalid JSON received response: " + response);
    }

}
