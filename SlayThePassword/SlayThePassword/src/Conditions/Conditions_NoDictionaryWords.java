package Conditions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Conditions_NoDictionaryWords implements Conditions{
    private Set<String> dictionary;

    public Conditions_NoDictionaryWords(int difficulty) throws IOException {
        this.dictionary = loadDictionary();
    }

    private Set<String> loadDictionary() throws IOException {
        Set<String> words = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/dictionary.txt"))); // Assuming dictionary.txt is in resources folder
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line.trim().toLowerCase());
        }
        return words;
    }

    @Override
    public boolean checkCondition(String input) {
        String[] words = input.split("\\s+"); // Split into words if there are spaces
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "The password must not contain any common dictionary words.";
    }


}
