package day8;

public class ScenicScore {

    public int computeUp(Integer x, Integer y, Integer[][] treeGrid) {
        if (x == 0) {
            return 0;
        }

        var score = 0;
        for (var row = x - 1; row >= 0; row--) {
            score++;

            if (treeGrid[x][y] <= treeGrid[row][y]) {
                break;
            }
        }

        return score;
    }

    public int computeDown(Integer x, Integer y, Integer[][] treeGrid) {
        if (x == treeGrid.length - 1) {
            return 0;
        }

        var score = 0;
        for (var row = x + 1; row < treeGrid.length; row++) {
            score++;

            if (treeGrid[x][y] <= treeGrid[row][y]) {
                break;
            }
        }

        return score;
    }

    public int computeRight(int x, int y, Integer[][] treeGrid) {
        if (y == treeGrid.length - 1) {
            return 0;
        }

        var score = 0;
        for (var col = y + 1; col < treeGrid.length; col++) {
            score++;

            if (treeGrid[x][y] <= treeGrid[x][col]) {
                break;
            }
        }

        return score;
    }

    public int computeLeft(int x, int y, Integer[][] treeGrid) {
        if (y == 0) {
            return 0;
        }
        var score = 0;
        for (var col = y - 1; col >= 0; col--) {
            score++;

            if (treeGrid[x][y] <= treeGrid[x][col]) {
                break;
            }
        }

        return score;
    }

    public int computeTotal(int x, int y, Integer[][] treeGrid) {
        return computeRight(x, y, treeGrid) *
            computeUp(x, y, treeGrid) *
            computeLeft(x, y, treeGrid) *
            computeDown(x, y, treeGrid);
    }


    public int maxScore(Integer[][] treeGrid) {
        var max = 0;

        for (int x = 0; x < treeGrid.length; x++) {
            for (int y = 0; y < treeGrid.length; y++) {
                if (computeTotal(x, y, treeGrid) > max) {
                    max = computeTotal(x, y, treeGrid);
                }
            }

        }
        return max;
    }
}