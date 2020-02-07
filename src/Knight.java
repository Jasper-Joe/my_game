import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) {
        //throw new UnsupportedOperationException();
        super(c);
    }


    public String toString() {
        String ans = "";
        if (this.color() == Color.BLACK) {
            ans = "bn";
        } else if (this.color() == Color.WHITE) {
            ans = "wn";
        }

        return ans;
        //throw new UnsupportedOperationException();
    }

    public List<String> moves(Board b, String loc) {
        HashMap<Character, Integer> alphaToInt = new HashMap<>();
        HashMap<Integer, Character> intToAlpha = new HashMap<>();
        alphaToInt.put('a', 1);
        alphaToInt.put('b', 2);
        alphaToInt.put('c', 3);
        alphaToInt.put('d', 4);
        alphaToInt.put('e', 5);
        alphaToInt.put('f', 6);
        alphaToInt.put('g', 7);
        alphaToInt.put('h', 8);

        intToAlpha.put(1, 'a');
        intToAlpha.put(2, 'b');
        intToAlpha.put(3, 'c');
        intToAlpha.put(4, 'd');
        intToAlpha.put(5, 'e');
        intToAlpha.put(6, 'f');
        intToAlpha.put(7, 'g');
        intToAlpha.put(8, 'h');
        List<String> ans = new ArrayList<>();
        char left = loc.charAt(0);
        char right = loc.charAt(1);
        int x = alphaToInt.get(left);
        int y = Integer.parseInt(String.valueOf(right));
        int px = 8 - y;
        int py = x - 1;
        if (px - 1 >= 0 && py - 2 >= 0) {
            char first = intToAlpha.get(py - 2 + 1);
            String second = String.valueOf(8 - px + 1);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);
            }
        }
        if (px - 2 >= 0 && py - 1 >= 0) {
            char first = intToAlpha.get(py);
            String second = String.valueOf(8 - px + 2);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }


        if (px + 1 < 8 && py - 2 >= 0) {
            char first = intToAlpha.get(py - 1);
            String second = String.valueOf(8 - px - 1);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }


        if (px + 2 < 8 && py - 1 >= 0) {
            char first = intToAlpha.get(py);
            String second = String.valueOf(8 - px - 2);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }

        if (px - 2 >= 0 && py + 1 < 8) {
            char first = intToAlpha.get(py + 2);
            String second = String.valueOf(8 - px + 2);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }


        if (px - 1 >= 0 && py + 2 < 8) {
            char first = intToAlpha.get(py + 3);
            String second = String.valueOf(8 - px + 1);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }


        if (px + 1 < 8 && py + 2 < 8) {
            char first = intToAlpha.get(py + 3);
            String second = String.valueOf(8 - px - 1);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }

        if (px + 2 < 8 && py + 1 < 8) {
            char first = intToAlpha.get(py + 2);
            String second = String.valueOf(8 - px - 2);
            String res = String.valueOf(first) + second;
            if (b.getPiece(res) == null || b.getPiece(res).color() != this.color()) {
                ans.add(res);

            }
        }


        return ans;

    }
}
