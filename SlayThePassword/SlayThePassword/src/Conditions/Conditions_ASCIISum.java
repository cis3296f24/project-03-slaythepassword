package Conditions;

public class Conditions_ASCIISum implements Conditions {
    private int targetSum;

    public Conditions_ASCIISum(int difficulty, int targetSum) {
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

    public String toString() {
        return "The sum of ASCII values of the characters must be " + targetSum + ".";
    }

}
