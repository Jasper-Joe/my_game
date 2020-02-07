import java.util.*;

public class Pawn extends Piece {
    boolean hasMoved=false;
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
        if(this.color()==Color.BLACK && px==1){
            String temp=String.valueOf(left)+"6";
            if(b.getPiece(temp)==null){
                ans.add(temp);
            }
            String temp2=String.valueOf(left)+"5";
            if(b.getPiece(temp2)==null){
                ans.add(temp2);
            }


            if(py-1>=0){
                char first=intToAlpha.get(py-1+1);
                String temp3=String.valueOf(first)+"6";
                if(b.getPiece(temp3)!=null && b.getPiece(temp3).color()==Color.WHITE){
                    ans.add(temp3);
                }
            }

            if(py+1<8){
                char first=intToAlpha.get(py+1+1);
                String temp4=String.valueOf(first)+"6";
                if(b.getPiece(temp4)!=null && b.getPiece(temp4).color()==Color.WHITE){
                    ans.add(temp4);
                }
            }

        }

        if(this.color()==Color.BLACK && px!=1){
            int cur=px+1;
            if(cur<8){
                String second=String.valueOf(8-cur);
                String temp=String.valueOf(left)+second;
                if(b.getPiece(temp)==null){
                    ans.add(temp);
                }
                if(py-1>=0){
                    char first=intToAlpha.get(py-1+1);
                    String temp2=String.valueOf(first)+second;
                    if(b.getPiece(temp2)!=null && b.getPiece(temp2).color()==Color.WHITE){
                        ans.add(temp2);
                    }
                }

                if(py+1<8){
                    char first=intToAlpha.get(py+1+1);
                    String temp2=String.valueOf(first)+second;
                    if(b.getPiece(temp2)!=null && b.getPiece(temp2).color()==Color.WHITE){
                        ans.add(temp2);
                    }
                }


            }

        }


        if(this.color()==Color.WHITE && px==6){
            String temp=String.valueOf(left)+"3";
            if(b.getPiece(temp)==null){
                ans.add(temp);
            }
            String temp2=String.valueOf(left)+"4";
            if(b.getPiece(temp2)==null){
                ans.add(temp2);
            }


            if(py-1>=0){
                char first=intToAlpha.get(py-1+1);
                String temp3=String.valueOf(first)+"3";
                if(b.getPiece(temp3)!=null && b.getPiece(temp3).color()==Color.WHITE){
                    ans.add(temp3);
                }
            }

            if(py+1<8){
                char first=intToAlpha.get(py+1+1);
                String temp4=String.valueOf(first)+"3";
                if(b.getPiece(temp4)!=null && b.getPiece(temp4).color()==Color.WHITE){
                    ans.add(temp4);
                }
            }

        }



        if(this.color()==Color.WHITE && px!=6){
            int cur=px-1;
            if(cur>=0){
                String second=String.valueOf(8-cur);
                String temp=String.valueOf(left)+second;
                if(b.getPiece(temp)==null){
                    ans.add(temp);
                }
                if(py-1>=0){
                    char first=intToAlpha.get(py-1+1);
                    String temp2=String.valueOf(first)+second;
                    if(b.getPiece(temp2)!=null && b.getPiece(temp2).color()==Color.BLACK){
                        ans.add(temp2);
                    }
                }

                if(py+1<8){
                    char first=intToAlpha.get(py+1+1);
                    String temp2=String.valueOf(first)+second;
                    if(b.getPiece(temp2)!=null && b.getPiece(temp2).color()==Color.BLACK){
                        ans.add(temp2);
                    }
                }


            }

        }


        return ans;
    }

}