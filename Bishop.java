/**
 * Represents a specific chess Piece called a Bishop.
 * A Bishop can move diagonally.
 *
 * @author sdesai88
 * @version 10/11/17
*/
public class Bishop extends Piece {

    /**
     * Creates a Bishop with a specific color.
     *
     * @param color : a Color (either black or white)
    */
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "B";
    }

    @Override
    public String fenName() {
        if (super.getColor() == Color.WHITE) {
            return "B";
        } else {
            return "b";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {
        String moveStr = "";
        char pieceRank = square.getRank();
        char pieceFile = square.getFile();
        final int rankInt = pieceRank - 0;
        final int fileInt = pieceFile - 0;

        char rankToAdd, fileToAdd;

        // '1' as an int is 49 & 'a' as an int is 97
        // '8' as an int is 56 & 'h' as in ant is 104

        // down left diagonal
        int rankPointer = rankInt - 1;
        int filePointer = fileInt - 1;
        while ((rankPointer >= 49) && (filePointer >= 97)) {
            rankToAdd = (char) (rankPointer);
            fileToAdd = (char) (filePointer);
            moveStr = moveStr + fileToAdd + rankToAdd + " ";
            rankPointer--;
            filePointer--;
        }

        // up right diagonal
        rankPointer = rankInt + 1;
        filePointer = fileInt + 1;
        while ((rankPointer <= 56) && (filePointer <= 104)) {
            rankToAdd = (char) (rankPointer);
            fileToAdd = (char) (filePointer);
            moveStr = moveStr + fileToAdd + rankToAdd + " ";
            rankPointer++;
            filePointer++;
        }

        // up left diagonal
        rankPointer = rankInt + 1;
        filePointer = fileInt - 1;
        while ((rankPointer <= 56) && (filePointer >= 97)) {
            rankToAdd = (char) (rankPointer);
            fileToAdd = (char) (filePointer);
            moveStr = moveStr + fileToAdd + rankToAdd + " ";
            rankPointer++;
            filePointer--;
        }

        // down right diagonal
        rankPointer = rankInt - 1;
        filePointer = fileInt + 1;
        while ((rankPointer >= 49) && (filePointer <= 104)) {
            rankToAdd = (char) (rankPointer);
            fileToAdd = (char) (filePointer);
            moveStr = moveStr + fileToAdd + rankToAdd + " ";
            rankPointer--;
            filePointer++;
        }

        String[] possibleMoves = moveStr.split("\\s+");
        Square[] squareArr = new Square[possibleMoves.length];
        for (int i = 0; i < squareArr.length; i++) {
            squareArr[i] = new Square(possibleMoves[i]);
        }

        return squareArr;
    }
}