package tutorial;

// NOW THIS CLASS WILL CHANGE ONLY IF THE WAY THAT WE STORE THE USER CHANGES.
public class UserPersistenceService
{
    private final Store store = new Store();

    public void saveUser(User user)
    {
        store.store(user);
    }

}
