package mvvm.data;

public class LoginRepository {

    private static final LoginRepository instance = new LoginRepository();

    private LoginRepository( ) { }

    public static LoginRepository getInstance() {
        return instance;
    }

    public String login(String username) {
        return  "用户: " + username;
    }

}