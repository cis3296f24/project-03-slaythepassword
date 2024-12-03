package Conditions;

public class Conditions_three_digits implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        long digitCount = input.chars()
                .filter(Character::isDigit)
                .count();

        return digitCount == 3;
    }

    @Override
    public String toString() {
        return "Password must contain exactly three digits.";
    }

    @Override
    public int getDifficulty() {
        return 5;
    }
}
