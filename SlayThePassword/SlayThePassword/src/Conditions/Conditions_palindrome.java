package Conditions;

public class Conditions_palindrome implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        // Check if the input reads the same forwards and backwards
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Password must be a palindrome ex: 'madam', '1221', 'refer'";
    }

    @Override
    public int getDifficulty() {
        return 8;
    }
}
