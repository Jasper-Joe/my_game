import java.util.*;

abstract public class Piece {
    boolean hasMoved=false;
    Color cl;
    public Piece(Color x){
        cl=x;
    }
//    public static void registerPiece(PieceFactory pf) {
//        throw new UnsupportedOperationException();
//    }

    public static Piece createPiece(String name) {
        Piece res;
        //if(name=="br"){
            res=new Rook(Color.BLACK);
        //}
        return res;
        //throw new UnsupportedOperationException();
    }

    public Color color() {
        return cl;
        // You should write code here and just inherit it in
        // subclasses. For this to work, you should know
        // that subclasses can access superclass fields.
        //throw new UnsupportedOperationException();
    }

     abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}
