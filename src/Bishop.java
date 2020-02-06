import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) {
        //throw new UnsupportedOperationException();
        super(c);
    }


    public String toString() {
        //throw new UnsupportedOperationException();
        String ans="";
        if(this.color()==Color.BLACK){
            ans="bb";
        }
        else if(this.color()==Color.WHITE){
            ans="wb";
        }
        return ans;
    }

//    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
//    }

}
