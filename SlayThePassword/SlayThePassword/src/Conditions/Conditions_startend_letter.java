package Conditions;

public class Conditions_startend_letter implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return Character.isLetter(input.charAt(0)) && Character.isLetter(input.charAt(input.length() - 1));
        // Checks that the first and last characters are letters
    }

    @Override
    public String toString() {
        return "Password must start and end with a letter";
    }

    @Override
    public int getDifficulty() {
        return 7;
    }
}
