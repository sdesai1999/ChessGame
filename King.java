/**
 * Represents a specific chess Piece called a King.
 * A King can move one square in any direction.
 *
 * @author sdesai88
 * @version 10/11/17
*/
public class King extends Piece {

    /**
     * Creates a King with a specific color.
     *
     * @param color : a Color (either black or white)
    */
    public King(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "K";
    }

    @Override
    public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "K";
        } else {
            return "k";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {
        String moveStr = "";
        char currentRank = square.getRank();
        char currentFile = square.getFile();
        int currentRankInt = currentRank - 0;
        int currentFileInt = currentFile - 0;
        char upRank = (char) (currentRankInt + 1);
        char downRank = (char) (currentRankInt - 1);
        char leftFile = (char) (currentFileInt - 1);
        char rightFile = (char) (currentFileInt + 1);

        String move1 = "" + leftFile + upRank;
        String move2 = "" + leftFile + currentRank;
        String move3 = "" + leftFile + downRank;
        String move4 = "" + currentFile + upRank;
        String move5 = "" + currentFile + downRank;
        String move6 = "" + rightFile + upRank;
        String move7 = "" + rightFile + currentRank;
        String move8 = "" + rightFile + downRank;

        String[] tmpMovesArr = {move1, move2, move3, move4, move5, move6, move7,
                                move8};

        for (int i = 0; i < tmpMovesArr.length; i++) {
            if ((new Square(tmpMovesArr[i])).isValidSquare()) {
                moveStr = moveStr + tmpMovesArr[i] + " ";
            }
        }

        String[] possibleMoves = moveStr.split("\\s+");
        Square[] squareArr = new Square[possibleMoves.length];
        for (int i = 0; i < squareArr.length; i++) {
            squareArr[i] = new Square(possibleMoves[i]);
        }

        return squareArr;
    }
}