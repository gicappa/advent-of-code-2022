package day7;

import day7.command.BackCmd;
import day7.command.CdCmd;
import day7.command.FileCmd;
import day7.command.MkDirCmd;
import day7.command.RootCmd;
import java.util.ArrayList;
import java.util.List;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final LoadInput loader;
    private final Parser parser;

    public static void main(String... args) {
        new App().run();
    }

    public App() {
        loader = new LoadInput();
        parser = new Parser();
    }

    private void run() {
        System.out.printf(
            """
                --- Day 7: No Space Left On Device ---"
                        
                Sum of the sizes of the dir <=100000 %d
                The size of the smallest file that could free 30000000 is %d
                        
                --- End of the day ---%n
                """,
            sumSizesLessThan100000("/input.txt"),
            smallestDirToFree30000000("/input.txt", 70000000, 30000000));
    }

    public int sumSizesLessThan100000(String filename) {
        var commands = loader.load(filename);

        return findSizesMinorThan(buildDirTree(commands), 100000);
    }

    public int findSizesMinorThan(Dir root, int limit) {
        return root.traverse(new ArrayList<>()).stream()
            .filter(f -> f < limit)
            .mapToInt(Integer::intValue)
            .sum();
    }

    private Dir buildDirTree(List<String> commands) {
        commands.add("$ cd /");
        Dir root = new Dir();
        return commands.stream().reduce(root, (acc, d) ->
            switch (parser.parse(d)) {
                case RootCmd r -> root;
                case MkDirCmd c -> acc.mkdir(c.dir());
                case CdCmd c -> acc.cd(c.dir());
                case FileCmd s -> acc.addSize(s.size());
                case BackCmd b -> acc.parent();
                default -> acc;
            }, (x, y) -> x);
    }

    public int smallestDirToFree30000000(String filename, int diskSpace, int minimumFreeSpace) {
        Dir root = buildDirTree(loader.load(filename));
        return getSelectedSmallestFileSizeToFreeSpace(
            minimumFreeSpace, computeAvailableSpace(diskSpace, computeUsedSpace(root)),
            getDirSortedBySize(root));
    }

    private Integer computeUsedSpace(Dir root) {
        return root.totalSize();
    }

    private List<Integer> getDirSortedBySize(Dir root) {
        return root.traverse(new ArrayList<>()).stream().sorted().toList();
    }

    private int computeAvailableSpace(int diskSpace, Integer usedSpace) {
        return diskSpace - usedSpace;
    }

    public int getSelectedSmallestFileSizeToFreeSpace(
        int minimumFreeSpace, int availableSpace, List<Integer> dirsSortedBySize) {

        return dirsSortedBySize.stream()
            .filter(s -> availableSpace + s >= minimumFreeSpace)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No dir can free enough space"));
    }
}
