import Conditions.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Conditiontest {

    private static class TestCase {
        Conditions condition;
        String input;
        boolean expectedOutput;

        TestCase(Conditions condition, String input, boolean expectedOutput) {
            this.condition = condition;
            this.input = input;
            this.expectedOutput = expectedOutput;
        }

    }

    @Test
    public void conditionTestCases() {

        List<TestCase> conditionTesting = new ArrayList<>();
        conditionTesting.add(new TestCase(new Conditions_Cap(), "Abc", true));
        conditionTesting.add(new TestCase(new Conditions_Cap(), "abc", false));
        conditionTesting.add(new TestCase(new Conditions_Have_Number(), "123abc", true));
        conditionTesting.add(new TestCase(new Conditions_Have_Number(), "abcdef", false));
        conditionTesting.add(new TestCase(new Conditions_L1_Length(), "abcefghij", true));
        conditionTesting.add(new TestCase(new Conditions_L1_Length(), "abc123", false));
        conditionTesting.add(new TestCase(new Conditions_Special_char(), "abc!", true));
        conditionTesting.add(new TestCase(new Conditions_Special_char(), "abcs", false));
        conditionTesting.add(new TestCase(new Conditions_contain_vowel(), "abce", true));
        conditionTesting.add(new TestCase(new Conditions_contain_vowel(), "hjk", false));
        conditionTesting.add(new TestCase(new Conditions_have_twocap(), "abcHH", true));
        conditionTesting.add(new TestCase(new Conditions_have_twocap(), "abchh", false));
        conditionTesting.add(new TestCase(new Conditions_palindrome(), "level", true));
        conditionTesting.add(new TestCase(new Conditions_palindrome(), "abcasd", false));
        conditionTesting.add(new TestCase(new Conditions_startend_letter(), "a1234c", true));
        conditionTesting.add(new TestCase(new Conditions_startend_letter(), "a2bc1", false));
        conditionTesting.add(new TestCase(new Conditions_threetypes(), "a1#", true));
        conditionTesting.add(new TestCase(new Conditions_threetypes(), "abc", false));
        conditionTesting.add(new TestCase(new Conditions_LenAddtoPrime(), "abc", true));
        conditionTesting.add(new TestCase(new Conditions_LenAddtoPrime(), "abcd", false));
        conditionTesting.add(new TestCase(new Conditions_have_twospecialc(), "abcd!#", true));
        conditionTesting.add(new TestCase(new Conditions_have_twospecialc(), "abcds", false));
        conditionTesting.add(new TestCase(new Conditions_alphaSort(), "zyx", true));
        conditionTesting.add(new TestCase(new Conditions_alphaSort(), "abcds", false));
        conditionTesting.add(new TestCase(new Conditions_have_twocap(), "AbcdS", true));
        conditionTesting.add(new TestCase(new Conditions_have_twocap(), "abcsds", false));
        conditionTesting.add(new TestCase(new Conditions_containSlay(), "abcsdslay", true));
        conditionTesting.add(new TestCase(new Conditions_containSlay(), "skbcsds", false));

        for (TestCase testCase : conditionTesting) {
            boolean result = testCase.condition.checkCondition(testCase.input);
            assertEquals(testCase.expectedOutput, result,
                    "Failed for condition:" + testCase.condition.toString() + "input" + testCase.input);

        }

    }

}
