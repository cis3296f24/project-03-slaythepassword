package Conditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conditions_SpecialCharPlacement implements Conditions {
    private int difficulty;

    public Conditions_SpecialCharPlacement(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        Pattern pattern = Pattern.compile(
                "^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
