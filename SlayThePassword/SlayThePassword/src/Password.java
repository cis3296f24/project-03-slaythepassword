import Conditions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Random;

public class Password {

    private ArrayList<Conditions> conditionsList;
    private Conditions currentCondition;

    // private int totalDifficulty;

    public Password(int targetDifficulty) throws IOException {
        // create a list to store the conditions
        conditionsList = new ArrayList<>();
        conditionsList.add(new Conditions_contain_vowel());
        conditionsList.add(new Conditions_Cap());
        conditionsList.add(new Conditions_Have_Number());
        conditionsList.add(new Conditions_L1_Length());
        conditionsList.add(new Conditions_palindrome());
        conditionsList.add(new Conditions_threetypes());
        conditionsList.add(new Conditions_startend_letter());
        conditionsList.add(new Conditions_Special_char());
        conditionsList.add(new Conditions_have_twocap());
        conditionsList.add(new Conditions_alphaSort());
        conditionsList.add(new Conditions_have_twospecialc());
        conditionsList.add(new Conditions_have_twocap());
        conditionsList.add(new Conditions_containSlay());
        conditionsList.add(new Conditions_VowelCount(2, 2));
        conditionsList.add(new Conditions_NoRepeatingChars(3));
        conditionsList.add(new Conditions_SpecialCharPlacement(4));
        conditionsList.add(new Conditions_CharDiversity(5));
        // conditionsList.add(new Conditions_NoDictionaryWords(6));
        conditionsList.add(new Conditions_PatternBased(7, "[a-zA-Z]{2}\\d{2}[a-zA-Z]{2}"));
        conditionsList.add(new Conditions_ASCIISum(8, 300));
        conditionsList.add(new Conditions_have_two_digits());
        conditionsList.add(new Conditions_have_lowercase());
        conditionsList.add(new Conditions_three_digits());

        conditionsList.add(new Conditions_AlternatingCase(6));
        conditionsList.add(new Conditions_LimitedRepeats(6));
        conditionsList.add(new Conditions_SymbolPairs(7));
        conditionsList.add(new Conditions_NoSequentialChars(8));
        // totalDifficulty = 0;

        // filter conditons based on difficulty
        List<Conditions> filteredConditions = new ArrayList<>();
        for (Conditions condition : conditionsList) {
            if (condition.getDifficulty() == targetDifficulty) {
                filteredConditions.add(condition);

            }

        }
        if (filteredConditions.isEmpty()) {
            throw new IllegalArgumentException("No conditions with difficulty: " + targetDifficulty);

        }

        int numOfConditions = getNumofConditions(targetDifficulty);

        // generate the random conditions into a list
        Random rand = new Random();
        List<Conditions> selectedConditions = new ArrayList<>();
        while (selectedConditions.size() < numOfConditions && !filteredConditions.isEmpty()) {
            // select a random conditon from the index and make sure no uniques
            int index = rand.nextInt(filteredConditions.size());
            selectedConditions.add(filteredConditions.remove(index));

        }
        // stack conditions if needed
        if (numOfConditions > 1) {
            this.currentCondition = new Stack_conditions(selectedConditions, numOfConditions);

        } else {
            this.currentCondition = selectedConditions.get(0);
        }

    }

    // number of random conditons to gnerate
    public int getNumofConditions(int targetDifficulty) {
        // 1-3 get 1 condition
        if (targetDifficulty <= 3) {
            return 1;
            // 4-6 return 2 condition
        } else if (targetDifficulty <= 6) {
            return 2;

        }
        // 7-8 return 3 conditions
        else {
            return 3;
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

}