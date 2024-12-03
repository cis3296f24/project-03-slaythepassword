package Conditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conditions_PatternBased implements Conditions{
    private String pattern;

    public Conditions_PatternBased(int difficulty, String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean checkCondition(String input) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(input);
        return matcher.matches();
    }

    public String toString() {
        return "The password must follow the pattern: " + pattern;
    }

}
