public class RomanNumeral implements RomanNumeralGenerator {
    private void getTens(int number, StringBuilder romanNumeral) {
        for (int i = 0; i < number; i++) {
            romanNumeral.append("I");
        }
    }

    public String generate(int number) {
        StringBuilder romanNumeral = new StringBuilder();

        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Sorry, please enter a number between 1 and 3999 inclusive");
        }

        getTens(number, romanNumeral);
        return romanNumeral.toString();
    }
}
