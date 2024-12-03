package Conditions;

public class Conditions_CharDiversity implements Conditions {
    private int difficulty;

    public Conditions_CharDiversity(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        boolean hasUpper = !input.equals(input.toLowerCase());
        boolean hasLower = !input.equals(input.toUpperCase());
        boolean hasDigit = input.matches(".*\\d.*");
        boolean hasSpecial = input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
