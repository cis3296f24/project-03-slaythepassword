package Conditions;

public class Conditions_have_lowercase implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return input.chars().anyMatch(Character::isLowerCase);
    }

    @Override
    public String toString() {
        return "Password must contain at least one lowercase letter.";
    }

    @Override
    public int getDifficulty() {
        return 1;
    }
}
