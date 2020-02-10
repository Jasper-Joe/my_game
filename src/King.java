import java.util.*;

public class King extends Piece {
    public King(Color c) {
        super(c);
        //throw new UnsupportedOperationException();
    }


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

    public List<String> moves(Board b, String loc) {
        //throw new UnsupportedOperationException();
        HashMap<Character, Integer> alphaToInt=new HashMap<>();
        HashMap<Integer, Character> intToAlpha=new HashMap<>();
        alphaToInt.put('a',1);
        alphaToInt.put('b',2);
        alphaToInt.put('c',3);
        alphaToInt.put('d',4);
        alphaToInt.put('e',5);
        alphaToInt.put('f',6);
        alphaToInt.put('g',7);
        alphaToInt.put('h',8);

        intToAlpha.put(1,'a');
        intToAlpha.put(2,'b');
        intToAlpha.put(3,'c');
        intToAlpha.put(4,'d');
        intToAlpha.put(5,'e');
        intToAlpha.put(6,'f');
        intToAlpha.put(7,'g');
        intToAlpha.put(8,'h');

        List<String> ans=new ArrayList<>();
        char left=loc.charAt(0);
        char right=loc.charAt(1);
        int x=alphaToInt.get(left);
        int y=Integer.parseInt(String.valueOf(right));
        int px=8-y;
        int py=x-1;

        if(px+1<=7){
            String second=Integer.toString(y-1);
            String temp=String.valueOf(left)+second;
            if(b.getPiece(temp)==null || b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
            }
            if(py-1>=0){
                char cur=intToAlpha.get(py);
                String temp2=String.valueOf(cur)+second;
                if(b.getPiece(temp2)==null || b.getPiece(temp2).color()!=this.color()){
                    ans.add(temp2);
                }
            }
            if(py+1<8){
                char cur=intToAlpha.get(py+1+1);
                String temp3=String.valueOf(cur)+second;
                if(b.getPiece(temp3)==null || b.getPiece(temp3).color()!=this.color()){
                    ans.add(temp3);
                }
            }

        }

        if(py+1<8){
            char cur=intToAlpha.get(py+1+1);
            String temp4=String.valueOf(cur)+String.valueOf(right);
            if(b.getPiece(temp4)==null || b.getPiece(temp4).color()!=this.color()){
                ans.add(temp4);
            }
        }

        if(py-1>=0){
            char cur=intToAlpha.get(py);
            String temp5=String.valueOf(cur)+String.valueOf(right);
            if(b.getPiece(temp5)==null || b.getPiece(temp5).color()!=this.color()){
                ans.add(temp5);
            }
        }



        if(px-1>=0){
            String second=Integer.toString(y+1);
            String temp6=String.valueOf(left)+second;
            if(b.getPiece(temp6)==null || b.getPiece(temp6).color()!=this.color()){
                ans.add(temp6);
            }
            if(py-1>=0){
                char cur=intToAlpha.get(py);
                String temp7=String.valueOf(cur)+second;
                if(b.getPiece(temp7)==null || b.getPiece(temp7).color()!=this.color()){
                    ans.add(temp7);
                }
            }
            if(py+1<8){
                char cur=intToAlpha.get(py+1+1);
                String temp8=String.valueOf(cur)+second;
                if(b.getPiece(temp8)==null || b.getPiece(temp8).color()!=this.color()){
                    ans.add(temp8);
                }
            }

        }




        return ans;
    }

}
