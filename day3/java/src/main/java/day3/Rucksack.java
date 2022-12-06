package day3;

public class Rucksack {

    private final String pocketOne;
    private final String pocketTwo;

    public Rucksack(String line) {
        pocketOne = line.substring(0, line.length() / 2);
        pocketTwo = line.substring(line.length() / 2);
    }

    public Item extractItem() {
        return new Item(extractString());
    }

    public String extractString() {
        for (char c : pocketOne.toCharArray()) {
            for (char j : pocketTwo.toCharArray()) {
                if (c == j) {
                    return String.valueOf(c);
                }
            }
        }
        throw new RuntimeException("No item found");
    }

    public String pocketOne() {
        return pocketOne;
    }

    public String pocketTwo() {
        return pocketTwo;
    }
}
