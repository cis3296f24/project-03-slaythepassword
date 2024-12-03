package Conditions;

public class Conditions_contain_vowel implements Conditions {

    @Override
    // Invalid if input is null or empty
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Check if the input contains at least one vowel
        return input.toLowerCase().matches(".*[aeiou].*");
    }

    @Override
    public String toString() {
        return "Password must contain at least one vowel (a, e, i, o, u).";
    }

    @Override
    public int getDifficulty() {
        return 3;
    }
}