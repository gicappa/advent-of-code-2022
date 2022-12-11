package day8;

import java.util.List;

public class Parser {

    public Integer[][] parse(List<String> rows) {
        var grid = new Integer[rows.size()][rows.size()];

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.size(); j++) {
                grid[i][j] = Integer.parseInt(rows.get(i).split("")[j]);
            }
        }
        return grid;
    }
}
