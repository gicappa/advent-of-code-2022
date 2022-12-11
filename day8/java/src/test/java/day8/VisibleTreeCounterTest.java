package day8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisibleTreeCounterTest {

    private VisibleTreeCounter counter;

    @BeforeEach
    void beforeEach() {
        counter = new VisibleTreeCounter();
    }

    @Test
    void it_returns_an_array_of_the_same_size_of_the_input() {
        assertThat(counter.visibleFromLeft(new Integer[]{3, 0, 3, 7, 3})).hasSize(5);
    }

    @Test
    void it_returns_a_true_if_visible_false_if_not_from_left() {
        assertThat(counter.visibleFromLeft(new Integer[]{3, 0, 3, 7, 3}))
            .containsExactly(true, false, false, true, true);
        assertThat(counter.visibleFromLeft(new Integer[]{2, 5, 5, 1, 2}))
            .containsExactly(true, true, false, false, true);
    }

    @Test
    void it_returns_a_true_if_visible_false_if_not_from_right() {
        assertThat(counter.visibleFromRight(new Integer[]{3, 0, 3, 7, 3}))
            .containsExactly(true, false, false, true, true);
        assertThat(counter.visibleFromRight(new Integer[]{2, 5, 5, 1, 2}))
            .containsExactly(true, false, true, false, true);
        assertThat(counter.visibleFromRight(new Integer[]{5, 5, 4}))
            .containsExactly(true, true, true);
    }

    @Test
    void it_extracts_a_row_from_the_grid() {
        assertThat(counter.extractRow(1,
            new Integer[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}))
            .containsExactly(5, 6, 7, 8);
    }

    @Test
    void it_extracts_a_column_from_the_grid() {
        assertThat(counter.extractColumn(1,
            new Integer[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}))
            .containsExactly(2, 6, 10, 14);
    }

    @Test
    void it_transform_into_visibility_table_from_left() {
        Integer[][] treeVisibility = {{5, 5, 5}, {5, 5, 5}, {4, 4, 3}};
        Boolean[][] expected = {{true, false, true}, {true, false, true}, {true, false, true}};
        assertThat(counter.visibilityGridFromLeft(treeVisibility)).isEqualTo(expected);
    }

    @Test
    void it_transform_into_visibility_table_from_right() {
        Integer[][] treeVisibility = {{5, 5, 5}, {5, 2, 5}, {4, 4, 3}};
        Boolean[][] expected = {{true, false, true}, {true, false, true}, {true, true, true}};
        assertThat(counter.visibilityGridFromRight(treeVisibility)).isEqualTo(expected);
    }

    @Test
    void it_transform_into_visibility_table_from_top() {
        Integer[][] treeVisibility = {{5, 5, 5}, {5, 2, 7}, {4, 4, 3}};
        Boolean[][] expected = {{true, true, true}, {false, false, true}, {true, true, true}};
        assertThat(counter.visibilityGridFromTop(treeVisibility)).isEqualTo(expected);
    }

    @Test
    void it_transform_into_visibility_table_from_bottom() {
        Integer[][] treeVisibility = {{5, 5, 5}, {5, 2, 7}, {4, 4, 3}};
        Boolean[][] expected = {{true, true, true}, {true, false, true}, {true, true, true}};
        assertThat(counter.visibilityGridFromBottom(treeVisibility)).isEqualTo(expected);
    }

    //30373
    //25512
    //65332
    //33549
    //35390

    @Test
    void it_ORs_grids() {
        Boolean[][] gridLeft = new Boolean[][]{
            {true, false},
            {false, true}};
        Boolean[][] gridRight = new Boolean[][]{
            {true, true},
            {false, false}};

        assertThat(counter.or(gridLeft, gridRight)).isEqualTo(
            new Boolean[][]{
                {true, true},
                {false, true}});
    }

    @Test
    void it_why() {
        System.out.println(Arrays.toString(counter.visibleFromLeft(new Integer[]{2, 5, 5, 1, 2})));
        System.out.println(Arrays.toString(counter.visibleFromRight(new Integer[]{2, 5, 5, 1, 2})));
        System.out.println(Arrays.toString(counter.visibleFromLeft(new Integer[]{7, 1, 3, 4, 9})));
        System.out.println(Arrays.toString(counter.visibleFromRight(new Integer[]{7, 1, 3, 4, 9})));
    }


    @Test
    void it_intersects_the_grid() {
        Integer[][] treeVisibility = {
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5, 3, 9, 0}};
        Boolean[][] expected = {
            {true, true, true, true, true},
            {true, true, true, false, true},
            {true, true, false, true, true},
            {true, false, true, false, true},
            {true, true, true, true, true}};

        assertThat(counter.intersectVisibilityGrids(treeVisibility)).isEqualTo(expected);
    }

    @Test
    void it_counts_the_visibles() {
        Boolean[][] actual = {
            {true, true, true, true, true},
            {true, true, true, false, true},
            {true, true, false, true, true},
            {true, false, true, false, true},
            {true, true, true, true, true}};

        assertThat(counter.countVisibleTrees(actual)).isEqualTo(21);
    }
}