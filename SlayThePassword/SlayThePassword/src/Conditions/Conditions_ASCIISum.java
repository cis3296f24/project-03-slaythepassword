package Conditions;

public class Conditions_ASCIISum implements Conditions {
    private int difficulty;
    private int targetSum;

    public Conditions_ASCIISum(int difficulty, int targetSum) {
        this.difficulty = difficulty;
        this.targetSum = targetSum;
    }

    @Override
    public boolean checkCondition(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += (int) c;
        }
        return sum == targetSum;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
