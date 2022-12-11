package day8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScenicScoreTest {

    private ScenicScore scenicScore;
    private Integer[][] treeGrid;

    @BeforeEach
    void beforeEach() {
        scenicScore = new ScenicScore();
        treeGrid = new Integer[][]{
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5, 3, 9, 0}};

    }

    @Test
    public void it_return_the_scenic_score_up() {
        assertThat(scenicScore.computeUp(0, 2, treeGrid)).isEqualTo(0);
        assertThat(scenicScore.computeUp(1, 2, treeGrid)).isEqualTo(1);
        assertThat(scenicScore.computeUp(3, 2, treeGrid)).isEqualTo(2);
    }

    @Test
    public void it_return_the_scenic_score_down() {
        assertThat(scenicScore.computeDown(4, 1, treeGrid)).isEqualTo(0);
        assertThat(scenicScore.computeDown(1, 2, treeGrid)).isEqualTo(2);
        assertThat(scenicScore.computeDown(3, 2, treeGrid)).isEqualTo(1);
    }

    @Test
    public void it_return_the_scenic_score_right() {
        assertThat(scenicScore.computeRight(3, 4, treeGrid)).isEqualTo(0);
        assertThat(scenicScore.computeRight(1, 2, treeGrid)).isEqualTo(2);
        assertThat(scenicScore.computeRight(3, 2, treeGrid)).isEqualTo(2);

    }

    @Test
    public void it_return_the_scenic_score_left() {
        assertThat(scenicScore.computeLeft(3, 0, treeGrid)).isEqualTo(0);
        assertThat(scenicScore.computeLeft(1, 2, treeGrid)).isEqualTo(1);
        assertThat(scenicScore.computeLeft(3, 2, treeGrid)).isEqualTo(2);
    }

    @Test
    void it_computes_the_total_score() {
        assertThat(scenicScore.computeTotal(1, 2, treeGrid)).isEqualTo(4);
        assertThat(scenicScore.computeTotal(3, 2, treeGrid)).isEqualTo(8);
    }

    @Test
    void it_computeMaxScore() {
        assertThat(scenicScore.maxScore(treeGrid)).isEqualTo(8);
    }
}
