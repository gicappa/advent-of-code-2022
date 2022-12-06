package day4;

public class CleaningSections {

    private final Section sectionOne;
    private final Section sectionTwo;

    // "23-43,32-41"
    public CleaningSections(String cleaningLines) {
        var sectionOneString = cleaningLines.split(",")[0];
        var sectionTwoString = cleaningLines.split(",")[1];

        sectionOne = new Section(sectionOneString);
        sectionTwo = new Section(sectionTwoString);
    }

    public int overlapsTotalCount() {
        if (firstContainsSecond(sectionOne, sectionTwo) ||
            firstContainsSecond(sectionTwo, sectionOne)) {
            return 1;
        }

        return 0;
    }

    public int overlapsPartialCount() {
        if (sectionOne.end() >= sectionTwo.start() && sectionTwo.end() >= sectionOne.start()) {
            return 1;
        }

        return 0;
    }

    private boolean firstContainsSecond(Section first, Section second) {
        return first.start() <= second.start() && first.end() >= second.end();
    }

    public Section sectionOne() {
        return sectionOne;
    }

    public Section sectionTwo() {
        return sectionTwo;
    }
}
