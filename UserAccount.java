// UserAccount.java
public class UserAccount {
    public boolean validateAccountSettings(String username) {
        return isValidUsername(username);
    }

    public boolean updateAccountName(String username, String newName) {
        // Update the account name in the data store
        return isValidUsername(username) && isValidName(newName);
    }

    private boolean isValidUsername(String username) {
        return username != null && !username.contains(" ") && !username.isEmpty();
    }

    private boolean isValidName(String name) {
        return name != null && !name.isEmpty() && name.length() <= 50;
    }
}
