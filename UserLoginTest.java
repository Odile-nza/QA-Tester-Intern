// UserLoginTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//Class for testing user login functionality
public class UserLoginTest {
    private UserLogin userLogin = new UserLogin();

    // Test case for valid user login
    @Test
    public void testValidLogin() {
        //Try login with correct credentials and assert success
        boolean result = userLogin.loginUser("Odile_nza", "Password@123");
        Assertions.assertTrue(result);
    }

    // Parameterized test for invalid user login with various error cases
    @ParameterizedTest
    @CsvSource({
            "'Odile_nza','WrongPassword', Invalid password",
            "'WrongUsername','Password@123', Invalid username",
            "'WrongUsername','WrongPassword', Invalid username and password"
    })
    public void testInvalidLogin(String username, String password, String expectedErrorMessage) {
        //Try login with incorrect credentials and assert failure
        boolean result = userLogin.loginUser(username, password);
        Assertions.assertFalse(result, expectedErrorMessage);
    }
}