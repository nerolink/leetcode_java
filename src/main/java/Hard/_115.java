package Hard;

import java.util.List;

public class _115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];

        for (int i = 1; i <=t.length(); i++) {          //t固定
            for (int j = i; j <=s.length(); j++) {      //s扩长
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
