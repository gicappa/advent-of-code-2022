package day8;

import java.util.Arrays;

public class VisibleTreeCounter {

    public Boolean[] visibleFromLeft(Integer[] treeHeights) {
        var maxHeight = -1;
        var visibilityArray = new Boolean[treeHeights.length];

        for (int i = 0; i < treeHeights.length; i++) {
            if (treeHeights[i] > maxHeight) {
                maxHeight = treeHeights[i];
                visibilityArray[i] = true;
            } else {
                visibilityArray[i] = false;
            }

            if (i == 0 || i == treeHeights.length - 1) {
                visibilityArray[i] = true;
            }

        }
        return visibilityArray;
    }

    public Boolean[] visibleFromRight(Integer[] treeHeights) {
        return reverse(visibleFromLeft(reverse(treeHeights)));
    }

    Integer[] reverse(Integer[] array) {
        var reverse = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - 1 - i];
        }
        return reverse;
    }

    Boolean[] reverse(Boolean[] array) {
        var reverse = new Boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - 1 - i];
        }
        return reverse;
    }

    public Integer[] extractRow(Integer rowNumber, Integer[][] treeHeight) {
        return treeHeight[rowNumber];
    }

    public Integer[] extractColumn(Integer columnNumber, Integer[][] treeHeight) {
        var column = new Integer[treeHeight.length];

        for (int i = 0; i < treeHeight.length; i++) {
            column[i] = treeHeight[i][columnNumber];
        }
        return column;
    }

    public Boolean[][] visibilityGridFromLeft(Integer[][] treeGrid) {
        var response = new Boolean[treeGrid.length][treeGrid.length];
        for (var i = 0; i < treeGrid.length; i++) {
            response[i] = visibleFromLeft(extractRow(i, treeGrid));
        }
        return response;
    }

    public Boolean[][] visibilityGridFromRight(Integer[][] treeGrid) {
        var response = new Boolean[treeGrid.length][treeGrid.length];
        for (var i = 0; i < treeGrid.length; i++) {
            response[i] = visibleFromRight(extractRow(i, treeGrid));
        }
        return response;
    }

    public Boolean[][] visibilityGridFromTop(Integer[][] treeGrid) {
        var response = new Boolean[treeGrid.length][treeGrid.length];
        for (var col = 0; col < treeGrid.length; col++) {
            Integer[] treeHeights = extractColumn(col, treeGrid);
            Boolean[] booleans = visibleFromLeft(treeHeights);
            for (var row = 0; row < treeGrid.length; row++) {
                response[row][col] = booleans[row];
            }
        }
        return response;
    }

    public Boolean[][] visibilityGridFromBottom(Integer[][] treeGrid) {
        var response = new Boolean[treeGrid.length][treeGrid.length];
        for (var i = 0; i < treeGrid.length; i++) {
            Integer[] treeHeights = extractColumn(i, treeGrid);
            Boolean[] booleans = visibleFromRight(treeHeights);
            for (var j = 0; j < treeGrid.length; j++) {
                response[j][i] = booleans[j];
            }
        }
        return response;
    }

    public Boolean[][] intersectVisibilityGrids(Integer[][] treeGrid) {
        var left = visibilityGridFromLeft(treeGrid);
        var right = visibilityGridFromRight(treeGrid);
        var top = visibilityGridFromTop(treeGrid);
        var bottom = visibilityGridFromBottom(treeGrid);
        var intersectOne = or(left, right);
        var intersectTwo = or(intersectOne, top);

        return or(intersectTwo, bottom);
    }

    public Boolean[][] or(Boolean[][] gridLeft, Boolean[][] gridRight) {
        var result = new Boolean[gridLeft.length][gridLeft.length];
        for (var i = 0; i < gridLeft.length; i++) {
            for (var j = 0; j < gridLeft.length; j++) {
                result[i][j] = gridLeft[i][j] || gridRight[i][j];
            }
        }
        return result;
    }

    public int countVisibleTrees(Boolean[][] actual) {
        var counter = 0;
        for (Boolean[] booleans : actual) {
            for (var j = 0; j < actual.length; j++) {
                if (booleans[j])
                    counter++;
            }
        }
        return counter;

    }
}
