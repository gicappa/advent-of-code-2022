package day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    private void run() {
        System.out.println("Total Priorities: " + totalPriorities("/input.txt"));
        System.out.println("Total Badges Priorities: " + totalBadgesPriorities("/input.txt"));
    }

    public int totalPriorities(String filename) {
        var lines = loader.load(filename);
        return lines.stream()
            .map(Rucksack::new)
            .map(Rucksack::extractItem)
            .map(Item::priority)
            .mapToInt(Integer::intValue)
            .sum();
    }

    public int totalBadgesPriorities(String filename) {
        var index = 0;
        var map = new HashMap<Integer, List<String>>();
        for (String line : loader.load(filename)) {
            var collectionNumber = index++ / 3;
            var currentTriplet = map.get(collectionNumber);

            if (currentTriplet == null) {
                currentTriplet = new ArrayList<>();
            }

            currentTriplet.add(line);
            map.put(collectionNumber, currentTriplet);
        }

        return map.values().stream()
            .map(ElfGroup::new)
            .map(ElfGroup::extractItem)
            .map(Item::priority)
            .mapToInt(Integer::intValue)
            .sum();
    }

}
