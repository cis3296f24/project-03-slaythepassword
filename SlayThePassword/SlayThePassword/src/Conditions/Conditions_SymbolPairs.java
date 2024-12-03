package Conditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conditions_SymbolPairs implements Conditions {
    private int difficulty;

    public Conditions_SymbolPairs(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean checkCondition(String input) {
        Pattern pattern = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{2}.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }
}
