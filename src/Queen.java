import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) {
        //throw new UnsupportedOperationException();
        super(c);
        }
    // implement appropriate methods

    public String toString() {
        String ans="";
        if(this.color()==Color.BLACK){
            ans="bq";
        }
        else if(this.color()==Color.WHITE){
            ans="wq";
        }

        return ans;
        //throw new UnsupportedOperationException();
    }

//    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
//    }

}
