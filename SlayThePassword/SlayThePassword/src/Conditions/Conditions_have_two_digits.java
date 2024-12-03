package Conditions;

public class Conditions_have_two_digits implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        long digitCount = input.chars()
                .filter(Character::isDigit)
                .count();

        return digitCount >= 2;
    }

    @Override
    public String toString() {
        return "Password must contain at least two digits.";
    }

    @Override
    public int getDifficulty() {
        return 4;
    }
}
