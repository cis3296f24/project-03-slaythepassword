package Conditions;

public class Conditions_add_to38 implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false; // Invalid if input is null or empty
        }

        // Ensure the input contains only digits
        if (!input.matches("\\d+")) {
            return false;
        }

        // Calculate the sum of the digits
        int sum = input.chars()
                .map(Character::getNumericValue)
                .sum();

        return sum == 38;
    }

    @Override
    public String toString() {
        return "The sum of the digits should be 38.";
    }

    @Override
    public int getDifficulty() {
        return 3;
    }
}