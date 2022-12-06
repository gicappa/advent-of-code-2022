package day3;

import java.util.List;

public class ElfGroup {

    private final String lineOne;
    private final String lineTwo;
    private final String lineThree;

    public ElfGroup(List<String> lines) {
        this.lineOne = lines.get(0);
        this.lineTwo = lines.get(1);
        this.lineThree = lines.get(2);
    }

    public Item extractItem() {
        for (char c : lineOne.toCharArray()) {
            for (char j : lineTwo.toCharArray()) {
                if (c == j) {
                    for (char k : lineThree.toCharArray()) {
                        if (j == k) {
                            return new Item(String.valueOf(k));
                        }
                    }
                }
            }
        }
        throw new RuntimeException("No item found");
    }
}
