package Conditions;

public class Conditions_CharDiversity implements Conditions{


    @Override
    public boolean checkCondition(String input) {
        boolean hasUpper = !input.equals(input.toLowerCase());
        boolean hasLower = !input.equals(input.toUpperCase());
        boolean hasDigit = input.matches(".*\\d.*");
        boolean hasSpecial = input.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public String toString() {
        return "The password must contain uppercase, lowercase, digits, and special characters.";
    }
}
