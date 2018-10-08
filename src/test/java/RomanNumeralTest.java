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
    public void canGetNumeralsForInputsBetween1And3() {
        assertEquals("I", romanNumeral.generate(1));
        assertEquals("II", romanNumeral.generate(2));
        assertEquals("III", romanNumeral.generate(3));
    }

    @Test
    public void canGetNumeralsForInputsOf4And9() {
        assertEquals("IV", romanNumeral.generate(4));
        assertEquals("IX", romanNumeral.generate(9));
    }

    @Test
    public void canGetNumeralsForInputsBetween5And8() {
        assertEquals("V", romanNumeral.generate(5));
        assertEquals("VI", romanNumeral.generate(6));
        assertEquals("VII", romanNumeral.generate(7));
        assertEquals("VIII", romanNumeral.generate(8));
    }

    @Test
    public void canGetNumeralsForCombinationsOf1sAnd1000s() {
        assertEquals("M", romanNumeral.generate(1000));
        assertEquals("MM", romanNumeral.generate(2000));
        assertEquals("MMM", romanNumeral.generate(3000));
        assertEquals("MI", romanNumeral.generate(1001));
        assertEquals("MMIV", romanNumeral.generate(2004));
        assertEquals("MMMV", romanNumeral.generate(3005));
        assertEquals("MVIII", romanNumeral.generate(1008));
        assertEquals("MMIX", romanNumeral.generate(2009));
    }

    @Test
    public void canGetNumeralsForCombinationsOf1sAnd100s() {
        assertEquals("C", romanNumeral.generate(100));
        assertEquals("CC", romanNumeral.generate(200));
        assertEquals("CCC", romanNumeral.generate(300));
        assertEquals("CD", romanNumeral.generate(400));
        assertEquals("D", romanNumeral.generate(500));
        assertEquals("DC", romanNumeral.generate(600));
        assertEquals("CM", romanNumeral.generate(900));
        assertEquals("DCCI", romanNumeral.generate(701));
        assertEquals("DCCCIV", romanNumeral.generate(804));
        assertEquals("CV", romanNumeral.generate(105));
        assertEquals("CCVIII", romanNumeral.generate(208));
        assertEquals("CCCIX", romanNumeral.generate(309));
    }
}

