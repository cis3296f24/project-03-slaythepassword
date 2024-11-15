
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Random;
import Conditions.Conditions;

public class Password {
    public final String folder = "Conditions";
    Conditions randCondition;
    List<Conditions> conditions;

    public Password() throws Exception {
        conditions = loads();
        Random random = new Random();
        randCondition = conditions.get(random.nextInt(conditions.size()));
    }

    private List<Conditions> loads() throws Exception {
        // initialize new ArrayList
        List<Conditions> conditions = new ArrayList<>();
        // initialize all files in a folder into an array
        File Condfolder = new File(folder);
        File[] files = Condfolder.listFiles((dir, name) -> name.endsWith(".class"));

        for (File file : files) {
            String className = file.getName().substring(0, file.getName().length() - 6);

            try {
                // Dynamically load each class using the forName() function
                Class<?> condClasses = Class.forName("conditions." + className);

                if (Conditions.class.isAssignableFrom(condClasses)) {
                    Conditions condition = (Conditions) condClasses.getDeclaredConstructor().newInstance();
                    conditions.add(condition);
                }
            } catch (Exception e) {
                System.err.println("Unable to propperly load Condition");
            }
        }

        return conditions;
    }

    public void validate(String userInput) {
        try {
            randCondition.checkCondition(userInput);
            System.out.println("Password meets the condition");
        } catch (IllegalArgumentException e) {
            System.out.println("Password does not meet the condition: " + e.getMessage());
        }
    }

    // public void displayConditions() {
    // System.out.println("hint: " + randCondition.hint());

    // }
}