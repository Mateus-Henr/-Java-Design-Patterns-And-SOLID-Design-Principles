package tutorial;

/*  Identifying of we have to apply the Single Responsibility principle

    By asking the following 2 questions, we can identify whether we are following the principle or not.
        1. What is this class supposed to do?
        2. What is this class doing right now?


    Controller
    • A controller in an app is supposed to receive the request, and send a response to the client. It shouldn't
      have any business logic in it.


    Why the principle is getting violated
    • In the context of this app, the controller does have business logic since it is creation a user, validating data,
      and storing the object. It all means that this class will have plenty of reasons to change.


    How to fix that
    • BEFORE EVERYTHING, make sure that you have a good test case ready to test if everything is working after all the
      modifications. In the case of this app, the main method will be our test cases. However, in a real app this
      mustn't be used.
    • Remember that a controller shouldn't have any business logic, so we will be moving them to more suitable places.
      In this case, the controller will only be responsible for creating the user, but the business logic that involves
      the user creation won't be here.


    Package organization
    • Packages are often organized based on "features". Types that provide same feature together go in same package
      together. But what is a feature is upto the developer or team or project to decide.
    • For example, many teams use code level concerns like Persistence, Validation, Interface, Business logic,
      Domain which are needed for application to work as "features" and create packages accordingly.
    • So for example you'll see a package for all persistence related code in one package and so on. These type of
      projects often rely on type name to indicate actual "business usecase" e.g. you'll have UserPersistenceService in
      com.company,project.persist package.
    • Other teams choose to define feature based on actual business usecase e.g. authentication, signup, administration,
      ordering etc. So in these projects you'll see package called e.g. auth which contains all types needed for doing
      user authentication.


    Let's take the example in question of validator and persistence.

    Questions to ask typically are:

    1. Does validation and persistence code always change together? - (If I changed address validation does my persistence code change)
        If our answer is yes then having them in single package will make a more cohesive package.

    2. Can I use persistence service WITHOUT validation service and use validation service WITHOUT persistence?
        If our answer is no then having them in single package will make it more cohesive package.
 */


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// Handles incoming JSON requests that work on User resource/entity.
public class UserController
{
    private final UserPersistenceService persistenceService = new UserPersistenceService();

    // Creates a new user.
    public String createUser(String userJson) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        UserValidator validator = new UserValidator();

        boolean valid = validator.validateUser(user);

        if (!valid)
        {
            return "ERROR";
        }

        persistenceService.saveUser(user);

        return "SUCCESS";
    }

}