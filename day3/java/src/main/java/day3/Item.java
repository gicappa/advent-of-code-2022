package day3;

import java.util.Objects;

public class Item {

    private final String item;

    public Item(String item) {
        this.item = item;
    }

    public Integer priority() {
        var p = (int) item.charAt(0) - 96;

        return p <= 0 ? (int) item.charAt(0) - 38 : p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item1 = (Item) o;
        return Objects.equals(item, item1.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}

