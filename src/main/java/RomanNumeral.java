public class RomanNumeral implements RomanNumeralGenerator {
    private void getThousands(int number, StringBuilder romanNumeral) {
        while (number > 999) {
            romanNumeral.append("M");
            number -= 1000;
        }
        getHundreds(number, romanNumeral);
    }

    private void getHundreds(int number, StringBuilder romanNumeral) {
        if (number >= 900 && number <= 999) {
            romanNumeral.append("CM");
            number -= 900;
        } else if (number >= 400 && number <= 499) {
            romanNumeral.append("CD");
            number -= 400;
        }

        if (number >= 500 && number <= 899) {
            romanNumeral.append("D");
            number -= 500;
        }

        while (number <= 399 && number > 99) {
            romanNumeral.append("C");
            number -= 100;
        }
        getTens(number, romanNumeral);
    }

    private void getTens(int number, StringBuilder romanNumeral) {
        // Handle tens logic
        getOnes(number, romanNumeral);
    }

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

    private String getUnits(int number) {
        StringBuilder romanNumeral = new StringBuilder();
        getThousands(number, romanNumeral);
        return romanNumeral.toString();
    }

    public String generate(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Sorry, please enter a number between 1 and 3999 inclusive");
        }
        return getUnits(number);
    }
}
