
package Conditions;

public class Conditions_VowelCount implements Conditions {
    private int minVowels;
    private int difficulty;

    public Conditions_VowelCount(int minVowels, int difficulty) {
        this.minVowels = minVowels;
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        int vowelCount = 0;
        String vowels = "aeiouAEIOU";
        for (char c : input.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelCount++;
            }
        }
        return vowelCount >= minVowels;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
