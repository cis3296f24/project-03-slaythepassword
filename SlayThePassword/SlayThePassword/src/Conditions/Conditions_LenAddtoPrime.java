
package Conditions;

public class Conditions_LenAddtoPrime implements Conditions {
    @Override
    public boolean checkCondition(String input) {
        if (input == null) {
            return false;

        }
        int length = input.length();
        return isPrime(length);

    }

    public boolean isPrime(int length) {
        if (length < 2) {
            return false;

        }
        for (int i = 2; i <= Math.sqrt(length); i++) {
            if (length % i == 0) {
                return false;

            }
        }
        return true;

    }

    @Override
    public String toString() {
        return "The length of your password must be a prime number.";
    }

    @Override
    public int getDifficulty() {
        return 8;
    }

}
