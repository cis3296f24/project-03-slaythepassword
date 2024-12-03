package Conditions;

public class Conditions_NoRepeatingChars implements Conditions {
    private int difficulty;

    public Conditions_NoRepeatingChars(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
