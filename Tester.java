import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tester {
    public static void main(String[] args) {
        Ply wht1 = new Ply(new King(Color.WHITE), new Square("a1"),
            new Square("a2"), Optional.empty());
        Ply blk1 = new Ply(new Rook(Color.BLACK), new Square("h8"),
            new Square("h1"), Optional.of("test comment blk1"));
        Ply wht2 = new Ply(new Bishop(Color.WHITE), new Square("b4"),
            new Square("d6"), Optional.of("test comment wht2"));
        Ply blk2 = new Ply(new Queen(Color.BLACK), new Square("c7"),
            new Square("c3"), Optional.empty());
        Ply wht3 = new Ply(new Knight(Color.WHITE), new Square("g8"),
            new Square("f6"), Optional.empty());
        Ply blk3 = new Ply(new Pawn(Color.BLACK), new Square("e7"),
            new Square("e5"), Optional.empty());
        Ply wht4 = new Ply(new Queen(Color.WHITE), new Square("d1"),
            new Square("a4"), Optional.of("test comment wht4"));
        Ply blk4 = new Ply(new King(Color.BLACK), new Square("e8"),
            new Square("d7"), Optional.of("test comment blk4"));


        List<Move> list1 = new ArrayList<>();
        list1.add(new Move(wht1, blk1));
        list1.add(new Move(wht2, blk2));
        list1.add(new Move(wht3, blk3));
        list1.add(new Move(wht4, blk4));

        ChessGame game1 = new ChessGame(list1);
        System.out.println(game1.getMovesWithoutComment());
        System.out.println(game1.getMovesWithComment());
        System.out.println(game1.getMovesWithPiece(new Queen(Color.BLACK)));
        System.out.println(game1.getMovesWithPiece(new King(Color.BLACK)));
    }
}