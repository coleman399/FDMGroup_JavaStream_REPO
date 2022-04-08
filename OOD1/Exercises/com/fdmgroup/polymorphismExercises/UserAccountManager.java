import java.util.ArrayList;

public class UserAccountManager {
    private ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();

    public void addUser(UserAccount account) {
        userAccounts.add(account);
    }

    public boolean login(String username, String password) {
        boolean result = false;
        for (UserAccount account : userAccounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
