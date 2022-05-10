package tutorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class is now in charge of all the validation that the controller was previously
// doing. THIS CLASS NOW WILL ONLY BE CHANGED IF THE VALIDATION LOGIC CHANGES.
public class UserValidator
{
    public boolean validateUser(User user)
    {
        return isValidUser(user);
    }

    // Validates the user object.
    private boolean isValidUser(User user)
    {
        if (!isPresent(user.getName()))
        {
            return false;
        }

        user.setName(user.getName().trim());

        if (!isValidAlphaNumeric(user.getName()))
        {
            return false;
        }

        if (user.getEmail() == null || user.getEmail().trim().length() == 0)
        {
            return false;
        }

        user.setEmail(user.getEmail().trim());

        return isValidEmail(user.getEmail());
    }

    // Simply checks if value is null or empty.
    private boolean isPresent(String value)
    {
        return value != null && value.trim().length() > 0;
    }

    // Checks string for special characters.
    private boolean isValidAlphaNumeric(String value)
    {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);

        return !matcher.find();
    }

    // Check string for valid email address - this is not for prod.
    // Just for demo. This fails for lots of valid emails.
    private boolean isValidEmail(String value)
    {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }

}
