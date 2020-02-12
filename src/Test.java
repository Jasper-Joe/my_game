import java.util.List;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
        Board b = Board.theBoard();

        Piece.registerPiece(new PawnFactory());
        Piece p1 = Piece.createPiece("wp");
        b.addPiece(p1, "a2");
        assert b.getPiece("a2") == p1;

        Piece p2 = Piece.createPiece("wp");
        b.addPiece(p2, "a3");
        assert b.getPiece("a3") == p2;

        Piece.registerPiece(new BishopFactory());
        Piece b1 = Piece.createPiece("wb");
        b.addPiece(b1, "b2");
        assert b.getPiece("b2") == b1;

        List<String> moveList1 = p1.moves(b, "a2");
        assert moveList1.size() == 0;

        b.movePiece("a3", "a4");
        List<String> moveList2 = p1.moves(b, "a2");
        assert moveList2.contains("a3");
        assert !(moveList2.contains("a4"));

        List<String> moveList3 = b1.moves(b, "b2");
        assert moveList3.size() == 9;
        assert moveList3.contains("a1") && moveList3.contains("a3") && moveList3.contains("c1") && moveList3.contains("c3")
                && moveList3.contains("d4") && moveList3.contains("e5") && moveList3.contains("f6") && moveList3.contains("g7")
                && moveList3.contains("h8");
    }

    public static void main(String[] args) {
        test1();
    }

}
