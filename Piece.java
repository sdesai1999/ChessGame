/**
 * Represents any chess piece.
 *
 * @author sdesai88
 * @version 10/11/17
*/
public abstract class Piece {

    private Color color;

    /**
     * Creates a Piece with a specific color.
     *
     * @param color : a Color (either black or white)
    */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * @return the color of the chess Piece
    */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return the PGN algebraic name of a Piece
    */
    public abstract String algebraicName();

    /**
     * @return the name of a Piece according to FEN
    */
    public abstract String fenName();

    /**
     * Finds all the possible Squares that a Piece can move to from a Square.
     *
     * @param square : the Square that the Piece is on
     * @return an array of Squares that the Piece can move to
    */
    public abstract Square[] movesFrom(Square square);

}