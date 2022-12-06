package day5;

import day4.LoadInput;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final LoadInput loader;
    private final MoveParser parser;

    public App() {
        loader = new LoadInput();
        parser = new MoveParser();
    }

    /**
     * [R] [J] [W] [R] [N]     [T] [T] [C] [R]         [P] [G]     [J] [P] [T] [Q]     [C] [M] [V]
     * [F] [F] [H] [G] [P] [M] [S] [Z]     [Z] [C] [Q] [P] [C] [P] [Q] [J] [J] [P] [H] [Z] [C] [T]
     * [H] [T] [H] [P] [G] [L] [V] [F] [W] [B] [L] [P] [D] [L] [N] [G] 1   2   3   4   5   6   7   8
     * 9
     */

    public void run() {
        var crane = setupCrane(Crane.newCrane9000());
        var result = computeCrateSequence("/input.txt", crane);
        System.out.printf("The crates sequence on the top of the stacks 9000 is %s%n", result);

        crane = setupCrane(Crane.newCrane9001());
        result = computeCrateSequence("/input.txt", crane);
        System.out.printf("The crates sequence on the top of the stacks 9001 is %s%n", result);
    }

    public String computeCrateSequence(String filename, Crane crane) {
        return loader.load(filename).stream()
            .map(parser::parse)
            .peek(System.out::println)
            .map(crane::handle)
            .reduce(null, (a, e) -> e)
            .getCrateSequence();
    }

    private Crane setupCrane(Crane crane) {
        crane.newStack("RQGPCF");
        crane.newStack("PCTW");
        crane.newStack("CMPHB");
        crane.newStack("RPMSQTL");
        crane.newStack("NGVZJHP");
        crane.newStack("JPD");
        crane.newStack("RTJFZPGL");
        crane.newStack("JTPFCHLN");
        crane.newStack("WCTHQZVG");
        return crane;
    }

    public static void main(String... args) {
        new App().run();
    }
}
