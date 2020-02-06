import java.util.*;

public class Rook extends Piece {

    public Rook(Color c) {

        super(c);
        //throw new UnsupportedOperationException();
        }
    // implement appropriate methods

    public String toString() {
        String ans="";
        if(this.color()==Color.BLACK){
            ans="br";
        }
        else if(this.color()==Color.WHITE){
            ans="wr";
        }

        return ans;
        //throw new UnsupportedOperationException();
    }

//    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
//    }

}
