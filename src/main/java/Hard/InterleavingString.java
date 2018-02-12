package Hard;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.equals("")) {
            if (s2.equals(s3)) {
                return true;
            }
            return false;
        }
        if (s2.equals("")) {
            if (s1.equals(s3)) {
                return true;
            }
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < c1.length + 1; i++) {
            for (int j = 0; j < c2.length+1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    if (dp[i][j - 1] && c2[j - 1] == c3[j - 1]) {
                        dp[i][j] = true;
                    }
                } else if (j == 0) {
                    if (dp[i - 1][j] && c1[i - 1] == c3[i - 1]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i - 1][j] && c1[i - 1] == c3[i - 1 + j]) {
                        dp[i][j] = true;
                    } else if (dp[i][j - 1] && c2[j - 1] == c3[i + j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[c1.length][c2.length];
    }

    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("a", "b", "ab"));
    }
}
