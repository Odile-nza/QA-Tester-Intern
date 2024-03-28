// UserRegistration.java
import java.util.regex.Pattern;

public class UserRegistration {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$");

    public boolean registerUser(String username, String password, String email) {
        return isValidUsername(username) && isValidPassword(password) && isValidEmail(email);
    }

    private boolean isValidUsername(String username) {
        return username != null && username.length() >= 3 && username.length() <= 20;
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 8 && password.length() <= 20;
    }

    private boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}