public class RomanNumeral implements RomanNumeralGenerator {
    public String generate(int number) {
        StringBuilder romanNumeral = new StringBuilder();

        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Sorry, please enter a number between 1 and 3999 inclusive");
        }

        return romanNumeral.toString();
    }
}
