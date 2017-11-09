/**
 * Represents a specific chess Piece called a Rook.
 * A Rook can move vertically and horizontally.
 *
 * @author sdesai88
 * @version 10/11/17
*/
public class Rook extends Piece {

    /**
     * Creates a Rook with a specific color.
     *
     * @param color : a Color (either black or white)
    */
    public Rook(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "R";
    }

    @Override
    public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "R";
        } else {
            return "r";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {
        String moveStr = "";
        char pieceRank = square.getRank();
        char pieceFile = square.getFile();

        // horizontal
        char fileToAdd = ' ';
        for (int i = 0; i < 8; i++) {
            fileToAdd = (char) (97 + i);
            if (fileToAdd != pieceFile) {
                moveStr = moveStr + fileToAdd + pieceRank + " ";
            }
        }

        // vertical
        char rankToAdd = ' ';
        for (int i = 0; i < 8; i++) {
            rankToAdd = (char) (49 + i);
            if (rankToAdd != pieceRank) {
                moveStr = moveStr + pieceFile + rankToAdd + " ";
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