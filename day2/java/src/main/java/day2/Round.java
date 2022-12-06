package day2;

import static day2.Result.DRAW;
import static day2.Result.LOSE;
import static day2.Result.WIN;
import static day2.Shape.PAPER;
import static day2.Shape.ROCK;
import static day2.Shape.SCISSORS;

public class Round {

    public OutcomePlayerTwo play(Shape playerOneShape, Shape playerTwoShape) {

        Result playerTwoResult = andTheWinnerIs(playerOneShape, playerTwoShape);

        return new OutcomePlayerTwo(playerTwoResult, playerTwoShape);
    }

    public OutcomePlayerTwo play(Shape playerOneShape, String code) {

        var playerTwoShape = codeToPlayerTwoShape(playerOneShape, code);

        Result playerTwoResult = andTheWinnerIs(playerOneShape, playerTwoShape);

        return new OutcomePlayerTwo(playerTwoResult, playerTwoShape);
    }

    private Shape codeToPlayerTwoShape(Shape playerOneShape, String code) {
        if (code.equals("Y")) {
            return playerOneShape;
        }
        if (code.equals("X")) {
            return playerOneShape.winsOn();
        }
        if (code.equals("Z")) {
            return playerOneShape.loseOn();
        }
        throw new RuntimeException("unsupported code");
    }

    private Result andTheWinnerIs(Shape playerOneShape, Shape playerTwoShape) {
        if (playerOneShape.equals(ROCK) && playerTwoShape.equals(SCISSORS)) {
            return LOSE;
        }

        if (playerOneShape.equals(SCISSORS) && playerTwoShape.equals(ROCK)) {
            return WIN;
        }

        if (playerOneShape.equals(SCISSORS) && playerTwoShape.equals(PAPER)) {
            return LOSE;
        }

        if (playerOneShape.equals(PAPER) && playerTwoShape.equals(SCISSORS)) {
            return WIN;
        }

        if (playerOneShape.equals(ROCK) && playerTwoShape.equals(PAPER)) {
            return WIN;
        }

        if (playerOneShape.equals(PAPER) && playerTwoShape.equals(ROCK)) {
            return LOSE;
        }

        if (playerOneShape.equals(playerTwoShape)) {
            return DRAW;
        }

        return null;
    }
}
