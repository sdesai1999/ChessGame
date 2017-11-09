/**
 * Represents one turn in a chess game
 *
 * @author sdesai88
 * @version 11/9/17
*/
public class Move {

    private Ply whitePly;
    private Ply blackPly;

    /**
     * Creates a Move with a whitePly and a blackPly
     *
     * @param whitePly : white player's move
     * @param blackPly : black player's move
    */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
     * @return white player's move
    */
    public Ply getWhitePly() {
        return this.whitePly;
    }

    /**
     * @return black player's move
    */
    public Ply getBlackPly() {
        return this.blackPly;
    }

    @Override
    public String toString() {
        return String.format("%s ... %s", whitePly, blackPly);
    }
}