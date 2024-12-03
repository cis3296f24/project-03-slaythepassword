package Conditions;

public class Conditions_alphaSort implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.length() < 3) {
            return false;
        }

        for (int i = 0; i <= input.length() - 3; i++) {
            if (isAlphabetical(input.substring(i, i + 3))) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlphabetical(String substring) {
        for (int i = 0; i < substring.length() - 1; i++) {
            if (substring.charAt(i) > substring.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "The password must contain an alphabetically sorted substring of at least 3 characters.";
    }

    @Override
    public int getDifficulty() {
        return 7;
    }

}
