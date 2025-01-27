class Solution {

    class Pair {
        int num;
        StringBuilder str;

        Pair(int num, StringBuilder str) {
            this.num = num;
            this.str = str;
        }
    }


    public String decodeString(String s) {
        Stack<Pair> st = new Stack<>();
        int num = 0;
        StringBuilder str = new StringBuilder("");

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '[') {
                Pair next = new Pair(num, str);
                st.push(next);
                str = new StringBuilder("");
                num = 0;
            }

            if(Character.isDigit(ch)) {
                // num = num * 10 + Character.numericValue(ch);
                num = num * 10 + (ch - '0');
            }

            if(Character.isLetter(ch)) {
                str.append(ch);
            }

            if(ch == ']') {
                Pair p = st.pop();
                StringBuilder build = new StringBuilder(p.str);
                for(int j = 1; j <= p.num; j++) {
                    build.append(str);
                }
                str = build;
            }
        }
        return str.toString();
    }
}