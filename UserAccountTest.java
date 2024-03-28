// UserAccountTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

// Class for testing user account functionality
public class UserAccountTest {

    //Creating an object of UserAccount for testing
    private UserAccount userAccount = new UserAccount();

    // Test case for valid account settings
    @Test
    public void testValidAccountSettings() {
        ////Try validating account settings with a valid username and assert success
        boolean result = userAccount.validateAccountSettings("Odile_nza");
        Assertions.assertTrue(result);
    }

    // Parameterized test for invalid account settings with empty or blank usernames
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ",""})
    public void testInvalidAccountSettings(String username) {
        //Try to validate account settings with invalid usernames and assert failure
        boolean result = userAccount.validateAccountSettings(username);
        Assertions.assertFalse(result, "Empty or blank username should be invalid");
    }

    // Test case for successful account name update
    @Test
    public void testUpdateAccountNameSuccess() {
        boolean result = userAccount.updateAccountName("Odile_nza", "Nadine Dia");
        Assertions.assertTrue(result);
    }
    // Parameterized test for failed account name update with invalid new names or usernames
    @ParameterizedTest
    @CsvSource({
            "'Odile_nza',''",
            "'Odile_nza','This is a very long name that exceeds the maximum length allowed'"
    })
    public void testUpdateAccountNameFailure(String username, String newName) {
        //try to update account name with invalid data and assert failure
        boolean result = userAccount.updateAccountName(username, newName);
        Assertions.assertFalse(result, "Invalid name or username for account update");
    }
}