import Conditions.*;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Random;
import Conditions.Conditions;

public class Password {

    private ArrayList<Conditions> conditionsList;
    private Conditions currentCondition;

    private int totalDifficulty;

    public Password(int targetDifficulty) {
        // create a list to store the conditions
        conditionsList = new ArrayList<>();
        conditionsList.add(new Conditions_add_to38());
        conditionsList.add(new Conditions_Cap());
        conditionsList.add(new Conditions_Have_Number());
        conditionsList.add(new Conditions_L1_Length());
        conditionsList.add(new Conditions_Special_char());

        totalDifficulty = 0;

        // generate a random index for randome condition
        Random rand = new Random();
//        int index = rand.nextInt(conditionsList.size());
//        currentCondition = conditionsList.get(index);
        if (targetDifficulty == 1) { // Easy difficulty
            // Select one random condition
            currentCondition = conditionsList.get(rand.nextInt(conditionsList.size()));
            totalDifficulty = currentCondition.getDifficulty();
        } else { // Medium or Hard difficulty
            // Select two distinct random conditions
            int index1 = rand.nextInt(conditionsList.size());
            int index2;
            do {
                index2 = rand.nextInt(conditionsList.size());
            } while (index1 == index2); // Ensure the two conditions are different

            Conditions condition1 = conditionsList.get(index1);
            Conditions condition2 = conditionsList.get(index2);

            // Combine the conditions (you'll need to implement this)
            currentCondition = combineConditions(condition1, condition2);
            totalDifficulty = condition1.getDifficulty() + condition2.getDifficulty();
        }

    }

    // method to validate password
    public void validate(String input) {
        if (!currentCondition.checkCondition(input)) {
            throw new AssertionError("Invalid password! Try again.");
        }

    }

    // show the hint
    public void displayConditions() {
        System.out.println("Hint: " + currentCondition.toString());

    }

    public int getTotalDifficulty() {
        return totalDifficulty;
    }

    private Conditions combineConditions(Conditions condition1, Conditions condition2) {
        return new Conditions() {
            @Override
            public boolean checkCondition(String input) {
                return condition1.checkCondition(input) && condition2.checkCondition(input);
            }

            @Override
            public int getDifficulty() {
                return condition1.getDifficulty() + condition2.getDifficulty();
            }

            @Override
            public String toString() {
                return condition1.toString() + " and " + condition2.toString();
            }
        };
    }

}