// UserRegistrationTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//Class for testing user registration functionality
public class UserRegistrationTest {
    //Creating an object of UserRegistration
    private UserRegistration userRegistration = new UserRegistration();

    //Test case for valid user registration
    @Test
    public void testValidUserRegistration() {
        String username = "Odile_nza";
        String password = "Password123";
        String email = "odile@example.com";

        //Try registering a user and assert success
        boolean registrationSuccessful = userRegistration.registerUser(username, password, email);
        Assertions.assertTrue(registrationSuccessful);
    }

    // Parameterized test for invalid user registration
    @ParameterizedTest
    @CsvSource({
            ",'Password123','odile@example.com', Username cannot be empty",
            "'Odile_nza','','odile@example.com', Password cannot be empty",
            "'Odile_nza','Password123','invalid_email', Invalid email format"
    })
    public void testInvalidUserRegistration(String username, String password, String email, String expectedErrorMessage) {

        //Try registering a user with invalid dataa nd assert failure
        boolean registrationSuccessful = userRegistration.registerUser(username, password, email);
        Assertions.assertFalse(registrationSuccessful, expectedErrorMessage);
    }
}
