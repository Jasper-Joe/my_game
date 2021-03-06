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

        for(int i=px+1;i<8;i++){
            int num=8-i;
            String temp=String.valueOf(left)+String.valueOf(num);
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }

        for(int i=px-1;i>=0;i--){
            int num=8-i;
            String temp=String.valueOf(left)+String.valueOf(num);
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }

        for(int i=py-1;i>=0;i--){
            String second=String.valueOf(intToAlpha.get(i+1));
            String temp=second+String.valueOf(right);
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }


        for(int i=py+1;i<8;i++){
            String second=String.valueOf(intToAlpha.get(i+1));
            String temp=second+String.valueOf(right);
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }


        for(int i=px-1,j=py+1;i>=0 && j<8;i--,j++){
            char first=intToAlpha.get(j+1);
            String second=String.valueOf(8-i);
            String temp=String.valueOf(first)+second;
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);

        }

        for(int i=px+1,j=py+1;i<8 && j<8;i++,j++){
            char first=intToAlpha.get(j+1);
            String second=String.valueOf(8-i);
            String temp=String.valueOf(first)+second;
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }


        for(int i=px+1,j=py-1;i<8 && j>=0;i++,j--){
            char first=intToAlpha.get(j+1);
            String second=String.valueOf(8-i);
            String temp=String.valueOf(first)+second;
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }


        for(int i=px-1,j=py-1;i>=0 && j>=0;i--,j--){
            char first=intToAlpha.get(j+1);
            String second=String.valueOf(8-i);
            String temp=String.valueOf(first)+second;
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()==this.color()){
                break;
            }
            if(b.getPiece(temp)!=null && b.getPiece(temp).color()!=this.color()){
                ans.add(temp);
                break;
            }
            ans.add(temp);
        }



        Set<String> set=new LinkedHashSet<>();
        set.addAll(ans);
        ans.clear();
        ans.addAll(set);

        return ans;
    }

}
