package Hard;

public class _224 {
    public int maxProfit(int[] prices) {
        int res =0;
        int curSum = 0;
        for (int i = 1; i < prices.length; i++) {
            curSum += prices[i] - prices[i - 1];
            curSum = Math.max(curSum, 0);
            res = Math.max(curSum, res);
        }
        return res;
    }
}
