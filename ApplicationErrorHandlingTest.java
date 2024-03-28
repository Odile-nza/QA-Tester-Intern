// ApplicationErrorHandlingTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Class for testing application error handling
public class ApplicationErrorHandlingTest {

    // Test case for handling unexpected errors
    @Test
    public void testUnexpectedErrorHandling() {
        // Simulate unexpected error by causing a NullPointerException
        try {
            String nullString = null;
            nullString.length(); // line that will throw a NullPointerException
            Assertions.fail("Expected NullPointerException was not thrown");
        } catch (NullPointerException e) {
            Assertions.assertNotNull(e); // Verify that the caught exception is not null
        }
    }

    // Test case for handling divide by zero errors
    @Test
    public void testDivideByZeroError() {
        // Simulate a divide by zero error
        try {
            int result = 10 / 0;
            Assertions.fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            // Verify that the caught exception is not null
            Assertions.assertNotNull(e);
            Assertions.assertEquals("/ by zero", e.getMessage());
        }
    }
}
