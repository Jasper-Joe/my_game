import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) {
        //throw new UnsupportedOperationException();
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        //throw new UnsupportedOperationException();
        String ans="";
        if(this.color()==Color.BLACK){
            ans="bp";
        }
        else if(this.color()==Color.WHITE){
            ans="wp";
        }

        return ans;
    }

//    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
//    }

}