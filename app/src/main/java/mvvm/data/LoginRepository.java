package mvvm.data;

public class LoginRepository {

    private static volatile LoginRepository instance = new LoginRepository();
    private User user = null;

    private LoginRepository( ) { }

    public static LoginRepository getInstance() {
        return instance;
    }

    public User login(String username, String password) {
        user = new User("Hunter");
        return user;
    }

    public void logout() {
        user = null;
    }

}
