package Conditions;

public class Conditions_containSlay implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;

        }

        return input.contains("slay");

    }

    @Override
    public String toString() {
        return "Password must contain the word 'slay' ";

    }

    @Override
    public int getDifficulty() {
        return 6;
    }

}
