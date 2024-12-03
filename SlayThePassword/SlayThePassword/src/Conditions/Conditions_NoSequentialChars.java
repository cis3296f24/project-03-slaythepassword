package Conditions;

public class Conditions_NoSequentialChars implements Conditions {
    private int difficulty;

    public Conditions_NoSequentialChars(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        for (int i = 1; i < input.length() - 1; i++) {
            char prev = input.charAt(i - 1);
            char curr = input.charAt(i);
            char next = input.charAt(i + 1);
            if (Math.abs(curr - prev) == 1 && Math.abs(curr - next) == 1) {
                return false; // Three consecutive characters
            }
        }
        return true;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
