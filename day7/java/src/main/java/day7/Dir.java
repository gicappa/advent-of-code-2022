package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dir {

    private final String name;
    private final Dir parent;
    private final List<Dir> children;
    private Integer size;

    public Dir() {
        this("/", null);
    }

    public Dir(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.size = 0;
    }

    public Dir mkdir(String name) {
        children.add(new Dir(name, this));
        return this;
    }

    public Dir parent() {
        return parent;
    }

    public String name() {
        return name;
    }

    public Dir cd(String name) {
        return children.stream()
            .filter(Objects::nonNull)
            .filter(e -> e.name().equals(name))
            .findAny()
            .orElseThrow(() -> new RuntimeException("cd %s - not found".formatted(name)));
    }

    public Dir addSize(Integer size) {
        this.size += size;
        return this;
    }

    public Integer totalSize() {
        return children.stream()
            .reduce(size, (acc, e) -> acc += e.totalSize(), Integer::sum);
    }

    public List<Integer> traverse(List<Integer> sizes) {
        sizes.add(totalSize());
        return children.stream().reduce(sizes, (acc, e) -> e.traverse(sizes), (x, y) -> x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dir dir = (Dir) o;
        return name.equals(dir.name) && Objects.equals(parent, dir.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }
}
