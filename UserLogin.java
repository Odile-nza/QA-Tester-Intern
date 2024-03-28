public class UserLogin {
    public boolean loginUser(String username, String password) {
        if (isValidCredentials(username, password)) {
            return true; // Login successful
        } else {
            return false; // Login failed
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return (username.equals("Odile_nza") && password.equals("Password@123"));
    }
}
