import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Chess {

    public static void main(String[] args) throws IOException {
        HashMap<String,String> map=new HashMap<>();
//        String test="a1=wr";
//        String l=test.substring(0,2);
//        String r=test.substring(3);

        if (args.length != 2) {
            System.out.println("Usage: java Chess layout moves");
        }
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());
//        Board.theBoard().registerListener(new Logger());
        // args[0] is the layout file name
        // args[1] is the moves file name
        // Put your code to read the layout file and moves files
        // here.
        String layout =args[0];
        //String moves=args[1];
        String line;
        BufferedReader in =new BufferedReader(new FileReader(layout));
        while((line=in.readLine())!=null){
            if(line.charAt(0)=='#') continue;
            String first=line.substring(0,2);
            String second=line.substring(3);
            //System.out.println(first+second);
            map.put(first,second);
            Piece p=Piece.createPiece(second);
            Board.theBoard().addPiece(p,first);
        }

        // Leave the following code at the end of the simulation:
        System.out.println("Final board:");
        Board.theBoard().iterate(new BoardPrinter());
    }
}
