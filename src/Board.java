import java.util.Arrays;
import java.util.HashMap;
import java.lang.*;

public class Board {
    HashMap<Character, Integer> alphaToInt=new HashMap<>();
    HashMap<Integer, Character> intToAlpha=new HashMap<>();
    Logger lg=new Logger();
    BoardListener cnt[]=new BoardListener[100];
    static int count=0;
    private static Board myBoard=null;



    private Piece[][] pieces = new Piece[8][8];
    //private static Piece [][] pieces=null;
    private Board() {

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

    }

    public static Board theBoard() {
        if(myBoard==null){
            myBoard=new Board();
        }
        return myBoard;



    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        if(loc.charAt(0)!='a' && loc.charAt(0)!='b' && loc.charAt(0)!='c' && loc.charAt(0)!='d' && loc.charAt(0)!='e' && loc.charAt(0)!='f' && loc.charAt(0)!='g' && loc.charAt(0)!='h'){
            throw new UnsupportedOperationException();
        }
        int temp2=Integer.parseInt(loc.substring(1));
        if(temp2<1 || temp2>8){

            throw new UnsupportedOperationException();
        }
        char left=loc.charAt(0);
        char right=loc.charAt(1);
        int x=alphaToInt.get(left);
        int y=Integer.parseInt(String.valueOf(right));
        return pieces[8-y][x-1];


    }

    public void addPiece(Piece p, String loc) {
        char left=loc.charAt(0);
        char right=loc.charAt(1);
        int x=alphaToInt.get(left);
        int y=Integer.parseInt(String.valueOf(right));
        if(pieces[8-y][x-1]!=null){
            throw new UnsupportedOperationException();
        }
//        System.out.println(8-y);
//        System.out.println(x-1);
        pieces[8-y][x-1]=p;


    }

    public void movePiece(String from, String to) {
        char left=from.charAt(0);
        char right=from.charAt(1);
        int x=alphaToInt.get(left);
        int y=Integer.parseInt(String.valueOf(right));
        if(8-y<0 || 8-y>7 || x-1<0 || x-1>7){
            throw new UnsupportedOperationException();
        }
        if(pieces[8-y][x-1]==null){
            throw new UnsupportedOperationException();
        }


        char left2=to.charAt(0);
        char right2=to.charAt(1);
        int x2=alphaToInt.get(left2);
        int y2=Integer.parseInt(String.valueOf(right2));

        if(8-y2<0 || 8-y2>7 || x2-1<0 || x2-1>7){
            throw new UnsupportedOperationException();
        }
        int p1x=8-y;
        int p1y=x-1;
        //System.out.println(y2);
        int p2x=8-y2;
        int p2y=x2-1;


        Piece temp=pieces[8-y][x-1];
        if(temp.toString().charAt(1)=='b'){
            if((p2y-p1y)!=(p2x-p1x) && (p2y-p1y)!=-(p2x-p1x)){
                throw new UnsupportedOperationException();
            }
        }
        if(temp.toString().charAt(1)=='r'){
            if(p2y!=p1y && p1x!=p2x){
                throw new UnsupportedOperationException();
            }
        }
        if(temp.toString().charAt(1)=='k'){
            if(p2x>p1x+1 || p2x<p1x-1 || p2y>p1y+1 || p2y<p1y-1){
                throw new UnsupportedOperationException();
            }
        }
        if(temp.toString().charAt(1)=='q'){
            if(!(p2x==p1x || p2y==p1y || (p2y-p1y)==(p2x-p1x) || (p2y-p1y)==-(p2x-p1x) )){
                throw new UnsupportedOperationException();
            }
        }
        if(temp.toString().charAt(1)=='n'){
            if(!(2*(p2y-p1y)==(p2x-p1x) || 2*(p2y-p1y)==-(p2x-p1x))){
                throw new UnsupportedOperationException();
            }
        }
        if(temp.toString()=="bp"){
            if(pieces[p2x][p2y]!=null){
                throw new UnsupportedOperationException();
            }
            if(p1y!=p2y){

                    boolean flag=false;
                    if((p2y-p1y==1 && p1x+1==p2x) || (p1y-p2y==1 && p1x+1==p2x)){
                        if(pieces[p2x][p2y].color()==Color.WHITE){
                            flag=true;
                        }
                    }
                    if(!flag){
                        throw new UnsupportedOperationException();
                    }


            }

            if(temp.hasMoved==true){
                if(p2x-p1x!=1){
                    throw new UnsupportedOperationException();
                }
            }

            if(temp.hasMoved==false){
                if(!(p2x-p1x==1 || p2x-p1x==2)){
                    throw new UnsupportedOperationException();
                }
                if(p2x-p1x==2){
                    if(pieces[p1x+1][p1y]!=null){
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        if(temp.toString()=="wp"){
//            if(pieces[p2x][p2y]!=null){
//                System.out.println(p2x);
//                System.out.println(p2y);
//
//                throw new UnsupportedOperationException();
//            }

            if(p1y!=p2y){
                boolean flag=false;
                if((p2y-p1y==1 && p1x-1==p2x) || (p1y-p2y==1 && p1x-1==p2x)){
                    if(pieces[p2x][p2y].color()==Color.BLACK){
                        flag=true;
                    }
                }
                if(!flag){
                    throw new UnsupportedOperationException();
                }

            }
            if(temp.hasMoved==true){
                if(p2x-p1x!=-1){
                    //System.out.println("??");
                    throw new UnsupportedOperationException();
                }
            }
            if(temp.hasMoved==false){
                if(!(p2x-p1x==-1 || p2x-p1x==-2)){
//                    System.out.println(p2x);
//                    System.out.println(p1x);
                    throw new UnsupportedOperationException();
                }
                if(p2x-p1x==-2){
                    if(pieces[p1x-1][p1y]!=null){
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        this.lg.onMove(from,to,this.getPiece(from));
        if(this.getPiece(from)!=null && this.getPiece(to)!=null){
            this.lg.onCapture(this.getPiece(from),this.getPiece(to));
        }

        pieces[8-y][x-1]=null;
        pieces[8-y2][x2-1]=temp;

    }

    public void clear() {
        //throw new UnsupportedOperationException();
        pieces=null;
    }

    public void registerListener(BoardListener bl) {
//        cnt[count]=bl;
//        count++;
        //throw new UnsupportedOperationException();
    }
//
    public void removeListener(BoardListener bl) {
        //throw new UnsupportedOperationException();
        for(int i=0;i<cnt.length;i++){
            if(bl==cnt[i]){
                cnt[i]=null;
            }
        }
    }

    public void removeAllListeners() {
        Arrays.fill(cnt,null);
    }

    public void iterate(BoardExternalIterator bi) {

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char first=intToAlpha.get(j+1);
                int temp=8-i;
                String cur=String.valueOf(first)+String.valueOf(temp);


                bi.visit(cur,getPiece(cur));
            }
        }


    }
}