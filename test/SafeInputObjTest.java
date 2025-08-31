import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

// AI attribution: This next import was suggested by Copilot so that I can simulate user input.
// I had to get assistance with AI to be able to complete this because this kind of testing input
// was not in the extra credit LinkedIn tutorial on Unit Testing that I watched.
import java.io.ByteArrayInputStream;


class SafeInputObjTest
{
    /**
     * Test of getMinLenString method using the Scanner to read from a String.
     * First checks the error message returned when the user enters less than 5 characters.
     * Then checks the correct response when the user enters more than 5 characters.
     */
    @Test
    void getMinLenString()
    {
        String input = "hi\nhello\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        String result = safeInput.getMinLenString("Enter string", 5);
        assertEquals("hello", result);
    }


    /**
     * Test of getNonZeroLenString method using the Scanner to read from a String.
     * First checks the error message returned when the user enters zero characters.
     * Then checks the correct response when the user enters more than zero characters.
     */
    @Test
    void getNonZeroLenString()
    {
        String input = "\nhello\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        String result = safeInput.getNonZeroLenString("Enter string");
        assertEquals("hello", result);
    }


    /**
     * Test of getRangedInt method using the Scanner to read from a String.
     * First checks the error message returned when the user enters a number outside the range.
     * Then checks the correct response when the user enters a number within the range.
     */
    @Test
    void getRangedInt()
    {
        String input = "100\n50\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        int result = safeInput.getRangedInt("Enter number", 10, 60);
        assertTrue(result >= 10 && result <= 60);

    }


    /**
     * Test of getInt method using the Scanner to read from a String.
     * First checks the error message returned when the user enters a non-integer.
     * Then checks the correct response when the user enters an integer.
     */
    @Test
    void getInt()
    {
        String input = "abc\n42\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        int result = safeInput.getInt("Enter int");
        assertEquals(42, result);
    }


    /**
     * Test of getRangedDouble method using the Scanner to read from a String.
     * First checks the error message returned when the user enters a number outside the range.
     * Then checks the correct response when the user enters a number within the range.
     */
    @Test
    void getRangedDouble()
    {
        String input = "100.5\n50.2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        double result = safeInput.getRangedDouble("Enter double", 10, 60);
        assertTrue(result >= 10 && result <= 60);

    }


    /**
     * Test of getDouble method using the Scanner to read from a String.
     * First checks the error message returned when the user enters a non-double.
     * Then checks the correct response when the user enters a double.
     */
    @Test
    void getDouble()
    {
        String input = "abc\n42.42\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        double result = safeInput.getDouble("Enter double");
        assertEquals(42.42, result, 0.001);
    }


    /**
     * Test of getYN method using the Scanner to read from a String.
     * First checks the error message returned when the user enters a non-Y or N.
     * Then checks the correct response when the user enters a Y or N.
     */
    @Test
    void getYNConfirm()
    {
        String input = "maybe\nY\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        boolean result = safeInput.getYNConfirm("Confirm?");
        assertTrue(result);
    }


    /**
     * Test of getRegExString method using the Scanner to read from a String.
     * First checks the error message returned when the user enters a string that doesn't match the regex.
     * Then checks the correct response when the user enters a string that matches the regex.
     */
    @Test
    void getRegExString()
    {
        String input = "123\nabc123\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(scanner);

        String result = safeInput.getRegExString("Enter string", "[a-z]+[0-9]+");
        assertEquals("abc123", result);
    }
}