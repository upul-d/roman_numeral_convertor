import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RomanNumeralTest {
    private RomanNumeral romanNumeral;

    @Before
    public void before() {
        romanNumeral = new RomanNumeral();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void numberBelowLowerLimitThrowsException() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Sorry, please enter a number between 1 and 3999 inclusive");
        romanNumeral.generate(0);
    }

    @Test
    public void numberAboveUpperLimitThrowsException() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Sorry, please enter a number between 1 and 3999 inclusive");
        romanNumeral.generate(4000);
    }

    @Test
    public void canGetNumeralForInputBetween1And3() {
        assertEquals("I", romanNumeral.generate(1));
        assertEquals("II", romanNumeral.generate(2));
        assertEquals("III", romanNumeral.generate(3));
    }
}

