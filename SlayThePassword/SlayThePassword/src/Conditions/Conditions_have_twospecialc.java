package Conditions;

public class Conditions_have_twospecialc implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String specialChars = "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";
        long count = input.chars()
                .filter(ch -> specialChars.indexOf(ch) >= 0)
                .count();

        return count >= 2;
    }

    @Override
    public String toString() {
        return "The password must contain at least two special characters.";
    }

    @Override
    public int getDifficulty() {
        return 5;
    }
}
