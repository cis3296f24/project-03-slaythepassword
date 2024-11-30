package Conditions;

public class Conditions_threetypes implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null) {
            return false;
        }

        boolean hasLetter = input.chars().anyMatch(Character::isLetter);
        boolean hasDigit = input.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = input.chars().anyMatch(ch -> "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|".indexOf(ch) >= 0);

        // Ensure at least three of the types are present
        int types = (hasLetter ? 1 : 0) + (hasDigit ? 1 : 0) + (hasSpecial ? 1 : 0);
        return types >= 3;
    }

    @Override
    public String toString() {
        return "Password must contain at least three types of characters: letters, digits, special characters";
    }

    @Override
    public int getDifficulty() {
        return 7;
    }
}
