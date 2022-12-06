package day5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveParser {

    private static final Pattern p = Pattern.compile(
        "^move ([0-9]+) from ([0-9]+) to ([0-9]+)$");

    public Command parse(String line) {
        Matcher m = p.matcher(line);

        if (!m.find()) {
            return new Command(0, 1, 1);
        }

        return new Command(
            Integer.parseInt(m.group(1)),
            Integer.parseInt(m.group(2)),
            Integer.parseInt(m.group(3)));
    }

}
