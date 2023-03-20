import org.example.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void squareRootTruePositive(){
        assertEquals("Finding square root for True Positive", 1, calculator.sqroot(1), DELTA);
        assertEquals("Finding square root for True Positive", 2, calculator.sqroot(4), DELTA);
        assertEquals("Finding square root for True Positive", 6, calculator.sqroot(36), DELTA);
        assertEquals("Finding square root for True Positive", 10, calculator.sqroot(100), DELTA);
    }

    @Test
    public void squareRootFalsePositive(){
        assertNotEquals("Finding square root for False Positive", 1, calculator.sqroot(5), DELTA);
        assertNotEquals("Finding square root for False Positive", 5, calculator.sqroot(9), DELTA);
        assertNotEquals("Finding square root for False Positive", 12, calculator.sqroot(120), DELTA);
        assertNotEquals("Finding square root for False Positive", 6, calculator.sqroot(49), DELTA);

    }
    @Test
    public void factorialTruePositive(){
        assertEquals("Factorial of a number for True Positive", 1, calculator.fact(0), DELTA);
        assertEquals("Factorial of a number for True Positive", 1, calculator.fact(1), DELTA);
        assertEquals("Factorial of a number for True Positive", 120, calculator.fact(5), DELTA);
        assertEquals("Factorial of a number for True Positive", 5040, calculator.fact(7), DELTA);
        assertEquals("Factorial of a number for True Positive", 362880, calculator.fact(9), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Factorial of a number for False Positive", 0, calculator.fact(0), DELTA);
        assertNotEquals("Factorial of a number for False Positive", 9, calculator.fact(2), DELTA);
        assertNotEquals("Factorial of a number for False Positive", 42, calculator.fact(4), DELTA);
        assertNotEquals("Factorial of a number for False Positive", 10, calculator.fact(6), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Finding natural log for True Positive", 0, calculator.logarithm(1), DELTA);
    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Finding natural log for False Positive", 72, calculator.logarithm(5), DELTA);
        assertNotEquals("Finding natural log for False Positive", 10.9, calculator.logarithm(3.2), DELTA);
    }
    @Test
    public void powerTruePositive(){

        assertEquals("Finding power for True Positive", 1, calculator.power(1, 3), DELTA);
        assertEquals("Finding power for True Positive", 4, calculator.power(2, 2), DELTA);
        assertEquals("Finding power for True Positive", 64, calculator.power(4, 3), DELTA);
        assertEquals("Finding power for True Positive", 7776, calculator.power(6, 5), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Finding power for False Positive", 6, calculator.power(1, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -7, calculator.power(2, 4), DELTA);
        assertNotEquals("Finding power for False Positive", 99, calculator.power(3, 3), DELTA);
        assertNotEquals("Finding power for False Positive", 115, calculator.power(6, 3), DELTA);
    }

}
