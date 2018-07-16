package snippet;

import java.util.ArrayDeque;

public class BracketCheck {


    public static void main(String[] args) {

        String chkStr = "{[()]}";
        System.out.println(bracketCheck(chkStr));
        String chkStr2 = "{[(}]}";
        System.out.println(bracketCheck(chkStr2));
    }

    public static boolean bracketCheck(String str) {

        boolean res = true;
        ArrayDeque<Character> st = new ArrayDeque<>();

        int len = str.length();
        for (int i = 0; i < len; i++) {

            char ch = str.charAt(i);
            if (!st.isEmpty() &&
                    ((ch == ')' && st.peek().equals('('))
                            || (ch == '}' && st.peek().equals('{'))
                            || (ch == ']' && st.peek().equals('[')))) {
                st.pop();
            } else if (ch == ')' || ch == '}' || ch == ']') {
                res = false;
                break;
            } else {
                st.push(ch);
            }
        }
        return res;
    }
}
