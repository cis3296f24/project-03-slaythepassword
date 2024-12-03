package Conditions;

public class Conditions_LimitedRepeats implements Conditions {
    private int difficulty;

    public Conditions_LimitedRepeats(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        if (input.length() < 2) {
            return true; // No repeats possible
        }
        int repeatCount = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                repeatCount++;
                if (repeatCount > 2) {
                    return false;
                }
            } else {
                repeatCount = 1;
            }
        }
        return true;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
