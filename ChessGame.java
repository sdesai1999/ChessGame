import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

/**
 * Represents a sequence of Moves, which is a chess game
 *
 * @author sdesai88
 * @version 11/9/17
*/
public class ChessGame {

    private List<Move> moves;

    /**
     * Creates a ChessGame with a List of Moves
     *
     * @param moves : a List of Moves that make up a game
    */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * @param n : the index to get
     * @return the Move at the specified index
    */
    public Move getMove(int n) {
        return moves.get(n);
    }

    /**
     * @return the List of Moves
    */
    public List<Move> getMoves() {
        return this.moves;
    }

    /**
     * @param filter : a Predicate that tells the method what to filter
     * @return a new List that is filtered based on the Predicate
    */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> newList = new ArrayList<>();
        for (Move move : moves) {
            if (filter.test(move)) {
                newList.add(move);
            }
        }

        return newList;
    }

    /**
     * @return a List of moves where at least one Ply has a comment
    */
    public List<Move> getMovesWithComment() {
        return filter((move) -> {
                if (move.getWhitePly().getComment().isPresent()
                    || move.getBlackPly().getComment().isPresent()) {
                    return true;
                }

                return false;
            });
    }

    /**
     * @return a List of moves where no Ply has a comment
    */
    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                if (!(move.getWhitePly().getComment().isPresent())
                    && !(move.getBlackPly().getComment().isPresent())) {
                    return true;
                }

                return false;
            }
        });
    }

    /**
     * @param p : the Piece that the List will be filtered by
     * @return a List of moves with Piece p
    */
    public List<Move> getMovesWithPiece(Piece p) {
        return filter(new MovePredicate(p));
    }

    private class MovePredicate implements Predicate<Move> {

        private Piece piece;

        /**
         * Creates a MovePredicate with a Piece
         *
         * @param p : the Piece that will be tested
        */
        public MovePredicate(Piece p) {
            this.piece = p;
        }

        @Override
        public boolean test(Move move) {
            Piece whitePiece = move.getWhitePly().getPiece();
            Piece blackPiece = move.getBlackPly().getPiece();
            if (whitePiece.algebraicName().equals(piece.algebraicName())
                || blackPiece.algebraicName().equals(piece.algebraicName())) {
                return true;
            }

            return false;
        }
    }
}