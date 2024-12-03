package Conditions;

import java.util.List;

public class Stack_conditions implements Conditions {

    private final List<Conditions> stackedConditions;

    public Stack_conditions(List<Conditions> stackedConditions, int stackSize) {

        if (stackedConditions == null || stackedConditions.size() < stackSize) {
            throw new IllegalArgumentException("Not enough conditions to stack");

        }
        // debug here to make sure only the same difficulty level is added to stack
        int intialDiff = stackedConditions.get(0).getDifficulty();
        for (Conditions condition : stackedConditions) {
            if (condition.getDifficulty() != intialDiff) {
                throw new IllegalArgumentException("All conditions in the stack must have the same difficulty");

            }
        }

        // Ensure only correct number of conditons stacked according to level
        this.stackedConditions = stackedConditions.subList(0, stackSize);

    }

    @Override
    public boolean checkCondition(String input) {
        if (input == null || stackedConditions.isEmpty()) {
            return false;

        }

        // Ensure all condition is met
        for (Conditions condition : stackedConditions) {

            if (!condition.checkCondition(input)) {
                return false;

            }

        }
        return true;
    }

    @Override
    public String toString() {
        // display the stacked conditions
        StringBuilder hint = new StringBuilder("Password must satisfy all the following conditions:\n");
        for (Conditions conditions : stackedConditions) {
            hint.append("-").append(conditions.toString()).append("\n");

        }
        return hint.toString();

    }

    @Override
    public int getDifficulty() {
        return stackedConditions.get(0).getDifficulty();
    }

}
