package Conditions;

public class Conditions_NoRepeatingChars implements Conditions{

    @Override
    public boolean checkCondition(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "The password must not contain any repeating characters.";
    }

}
