// PasswordResetTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Class for testing password reset functionality
 class PasswordResetTest {

     //Creating object of PasswordReset for testing
    private PasswordReset passwordReset = new PasswordReset();

    // Test case for valid password reset with a valid username and password
    @Test
    public void testPasswordResetValidUsername() {
        //try password reset with a valid username and password, assert success
        boolean result = passwordReset.resetPassword("Odile_nza", "Odile@123");
        Assertions.assertTrue(result);
    }

    // Test case for invalid password reset with a valid username and invalid password
    @Test
    public void testPasswordResetInvalidPassword() {
        //try password reset with a valid username and invalid password, assert failure
        boolean result = passwordReset.resetPassword("Odile_nza", "Odile");
        Assertions.assertFalse(result);
    }

    // Parameterized test for invalid password reset with various error cases
    @ParameterizedTest
    @CsvSource({
            ",'Odile@123', Username cannot be empty",
            "'InvalidUser','Odile@123', Invalid username"
    })
    public void testInvalidPasswordReset(String username, String newPassword, String expectedErrorMessage) {
        //try password reset with invalid data and assert failure
        boolean result = passwordReset.resetPassword(username, newPassword);
        Assertions.assertFalse(result, expectedErrorMessage);
    }
}