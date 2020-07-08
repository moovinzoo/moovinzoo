public class Parentheses {
    public static int parentheses(char[] chrs) {
        MyStack<String> s = new MyStack<>();
        int position = -1;

        for (int i = 0; i < chrs.length; i++) {
            char c = chrs[i];

            if (c == '(') {
                if (s.length() == 0) {
                    position = i; // first left excess parenthesis
                }
                // TODO
                s.push(Integer.toString(i));

            } else {
                // TODO
                if (c != ')') continue;

                if (s.length() == 0) { // there was no ( before
                    return i;
                }
                s.pop();
                if (s.length() == 0) {
                    position = -1;
                }
            }
        }

        return position;
    }

    public static void main(String[] args) {
        System.out.println("Test result : " + parentheses("(()())(()()(".toCharArray()));
    }
}
