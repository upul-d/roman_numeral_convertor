public class RomanNumeral implements RomanNumeralGenerator {
    private void getOnes(int number, StringBuilder romanNumeral) {
        if (number == 9) {
            romanNumeral.append("IX");
        } else if (number == 4) {
            romanNumeral.append("IV");
        }

        if (number >= 5 && number <= 8) {
            romanNumeral.append("V");
            number -= 5;
        }

        while (number <= 3 && number > 0) {
            romanNumeral.append("I");
            number--;
        }
    }

    public String generate(int number) {
        StringBuilder romanNumeral = new StringBuilder();

        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Sorry, please enter a number between 1 and 3999 inclusive");
        }

        getOnes(number, romanNumeral);
        return romanNumeral.toString();
    }
}
