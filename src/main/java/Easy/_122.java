package Easy;

public class _122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int curSum = 0;
        int diff = 0;
        for (int i = 1 ; i <prices.length ; i++) {
            diff = prices[i] - prices[i - 1];
            if (diff < 0) {
                res += curSum;
                curSum = 0;
                continue;
            }
            curSum += diff;
            if (i == prices.length - 1) {
                res += curSum;
            }
        }
        return res;
    }
}
