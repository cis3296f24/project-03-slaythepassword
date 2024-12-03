package Conditions;

public class Conditions_have_twocap implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Count the number of uppercase letters in the input
        long uppercaseCount = input.chars()
                .filter(Character::isUpperCase)
                .count();

        // Return true if exactly two uppercase letters are present
        return uppercaseCount == 2;
    }

    @Override
    public String toString() {
        return "Password must contain exactly two uppercase letters.";
    }

    @Override
    public int getDifficulty() {
        return 5;
    }
}
