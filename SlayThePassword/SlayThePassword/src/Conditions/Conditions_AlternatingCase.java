package Conditions;

public class Conditions_AlternatingCase implements Conditions {
    private int difficulty;

    public Conditions_AlternatingCase(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        if (input.length() < 2) {
            return false;
        }
        boolean isUpper = Character.isUpperCase(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (isUpper && Character.isUpperCase(input.charAt(i)) ||
                    !isUpper && Character.isLowerCase(input.charAt(i))) {
                return false;
            }
            isUpper = !isUpper;
        }
        return true;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
