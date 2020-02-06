import java.util.*;

public class King extends Piece {
    public King(Color c) {
        super(c);
        //throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
        //throw new UnsupportedOperationException();
        String ans="";
        if(this.color()==Color.BLACK){
            ans="bk";
        }
        else if(this.color()==Color.WHITE){
            ans="wk";
        }
        return ans;
    }

//    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
//    }

}
