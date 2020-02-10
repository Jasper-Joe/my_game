import java.util.*;

abstract public class Piece {
    boolean hasMoved=false;
    Color cl;
    public Piece(Color x){
        cl=x;
    }
    public static void registerPiece(PieceFactory pf) {
        //throw new UnsupportedOperationException();

    }

    public static Piece createPiece(String name) {
        //System.out.println(name);
        Piece res;
        if(name.equals("br")){
            res=new Rook(Color.BLACK);
        }
        if(name.equals("bn")){
            res=new Knight(Color.BLACK);
        }
        if(name.equals("bb")){
            res=new Bishop(Color.BLACK);
        }
        if(name.equals("bp")){
            res=new Pawn(Color.BLACK);
        }
        if(name.equals("bk")){
            res=new King(Color.BLACK);
        }
        if(name.equals("bq")){
            res=new Queen(Color.BLACK);
        }
        if(name.equals("wp")){
            res=new Pawn(Color.WHITE);
        }
        if(name.equals("wq")){
            res=new Queen(Color.WHITE);
        }
        if(name.equals("wb")){
            res=new Bishop(Color.WHITE);
        }
        if(name.equals("wk")){
            res=new King(Color.WHITE);
        }
        if(name.equals("wr")){
            res=new Rook(Color.WHITE);
        }
        else{
            res=new Knight(Color.WHITE);
        }


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
