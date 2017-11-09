import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ChessGame {

    private List<Move> moves;

    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    public Move getMove(int n) {
        return moves.get(n);
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    public List<Move> filter(Predicate<Move> filter) {
        List<Move> newList = new ArrayList<>();
        for (Move move : moves) {
            if (filter.test(move)) {
                newList.add(move);
            }
        }

        return newList;
    }

    public List<Move> getMovesWithComment() {
        return filter((move) -> {
            if (move.getWhitePly().getComment().isPresent()
                || move.getBlackPly().getComment().isPresent()) {
                return true;
            }

            return false;
        });
    }

    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move move) {
                if (!(move.getWhitePly().getComment().isPresent())
                    && !(move.getBlackPly().getComment().isPresent())) {
                    return true;
                }

                return false;
            }
        });
    }
}

























