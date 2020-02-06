import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) {
        //throw new UnsupportedOperationException();
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        String ans="";
        if(this.color()==Color.BLACK){
            ans="bn";
        }
        else if(this.color()==Color.WHITE){
            ans="wn";
        }

        return ans;
        //throw new UnsupportedOperationException();
    }

//    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
//    }

}
