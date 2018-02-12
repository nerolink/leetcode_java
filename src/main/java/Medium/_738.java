package Medium;

public class _738 {
    public int monotoneIncreasingDigits(int N) {
        char[] c = (N + "").toCharArray();
        int mark = c.length;
        for (int i = c.length-1; i >0; i--) {
            if (c[i - 1] > c[i]) {
                mark = i - 1;
                c[i - 1]--;
            }
        }
        for (int i = mark+1; i <c.length ; i++) {
            c[i] = '9';
        }
        return Integer.parseInt(new String(c));
    }
}
