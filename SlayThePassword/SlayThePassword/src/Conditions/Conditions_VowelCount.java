
package Conditions;

public class Conditions_VowelCount implements Conditions{
    private int minVowels;

    public Conditions_VowelCount(int minVowels, int difficulty) {
        this.minVowels = minVowels;
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

    public String toString() {
        return "The password must contain at least " + minVowels + " vowels.";
    }

}
