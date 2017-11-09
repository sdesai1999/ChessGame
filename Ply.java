import java.util.Optional;

/**
 * Represents a player's move in chess.
 *
 * @author sdesai88
 * @version 11/8/17
*/
public class Ply {

    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

    /**
     * Creates an Ply with a Piece, original Square, ending Square, and comment
     *
     * @param piece : the Piece that will move
     * @param from : the Square that the Piece came from
     * @param to : the Square that the Piece will go to
     * @param comment : a String that may or may not exist
    */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    /**
     * @return piece : the Piece that will move
    */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * @return from : the original Square
    */
    public Square getFrom() {
        return this.from;
    }

    /**
     * @return to : the ending Square
    */
    public Square getTo() {
        return this.to;
    }

    /**
     * @return comment : the String thay may or not be there
    */
    public Optional<String> getComment() {
        return this.comment;
    }
}