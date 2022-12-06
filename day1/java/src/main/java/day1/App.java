package day1;

import static java.util.Comparator.naturalOrder;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final LoadInput loader;

    public static void main(String... args) {
        new App().run();
    }

    public App() {
        loader = new LoadInput();
    }

    public void run() {
        System.out.println("Max calories: " + returnsMaxCalories("/input.txt"));
        System.out.println("Three Max calories: " + returnsThreeMaxCalories("/input.txt"));
    }

    public int returnsThreeMaxCalories(String filename) {
        var caloriesList = loader.load(filename);
        return createListOfSummedCalories(caloriesList).stream()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::valueOf)
            .limit(3)
            .sum();
    }

    public int returnsMaxCalories(String filename) {
        var caloriesList = loader.load(filename);
        return createListOfSummedCalories(caloriesList).stream()
            .mapToInt(Integer::valueOf)
            .max().getAsInt();
    }

    public List<Integer> createListOfSummedCalories(List<String> strings) {
        return strings.stream()
            .reduce(new Calories(),
                (cals, e) ->
                e.isEmpty() ? cals.newSummary() : cals.add(Integer.parseInt(e)), Calories::add)
            .getSummaryList();
    }
}
