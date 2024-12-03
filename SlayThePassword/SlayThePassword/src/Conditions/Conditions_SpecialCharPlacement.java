package Conditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conditions_SpecialCharPlacement implements Conditions {

    @Override
    public boolean checkCondition(String input) {
        Pattern pattern = Pattern.compile("^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return "The password must start and end with a special character.";
    }

}
