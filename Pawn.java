/**
 * Represents a specific chess Piece called a Pawn.
 * A pawn can move one square forward, or two squares forward if the Pawn hasn't
 * moved yet.
 *
 * @author sdesai88
 * @version 10/11/17
*/
public class Pawn extends Piece {

    /**
     * Creates a Pawn with a specific color.
     *
     * @param color : a Color (either black or white)
    */
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "";
    }

    @Override
    public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "P";
        } else {
            return "p";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {
        String moveStr = "";
        char currentRank = square.getRank();
        char currentFile = square.getFile();
        int currentRankInt = currentRank - 0;
        int currentFileInt = currentFile - 0;
        char up1Rank = (char) (currentRankInt + 1);
        char up2Ranks = (char) (currentRankInt + 2);
        char down1Rank = (char) (currentRankInt - 1);
        char down2Ranks = (char) (currentRankInt - 2);
        String move1 = "", move2 = "";

        if (super.getColor() == Color.WHITE) {
            move1 = "" + currentFile + up1Rank;
            if ((new Square(move1)).isValidSquare()) {
                moveStr = moveStr + move1 + " ";
            } else {
                Square[] toReturn = new Square[0];
                return toReturn;
            }

            if (currentRank == '2') {
                move2 = "" + currentFile + up2Ranks;
                moveStr = moveStr + move2 + " ";
            }
        } else {
            move1 = "" + currentFile + down1Rank;
            if ((new Square(move1)).isValidSquare()) {
                moveStr = moveStr + move1 + " ";
            } else {
                Square[] toReturn = new Square[0];
                return toReturn;
            }

            if (currentRank == '7') {
                move2 = "" + currentFile + down2Ranks;
                moveStr = moveStr + move2 + " ";
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