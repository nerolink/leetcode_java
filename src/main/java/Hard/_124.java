package Hard;

public class _124 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private Integer max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return max;
    }

    private int maxValue(TreeNode node) {    //这一棵树上最长的经过根节点的单路径
        if (node == null) {
            return 0;
        }
        int res;
        int maxL = maxValue(node.left);
        int maxR = maxValue(node.right);
        int localMax;
        if (maxL > 0 && maxR > 0) {
            localMax = node.val + maxL + maxR;
        } else if (maxL <= 0 && maxR <= 0) {
            localMax = node.val;
        } else if (maxL <= 0&&maxR>0) {
            localMax = node.val + maxR;
        } else {
            localMax = node.val + maxL;
        }
        max = Math.max(localMax, max);
        res = Math.max(maxL, maxR);
        if (res < 0) {
            res = node.val;
        } else {
            res += node.val;
        }
        return res;
    }
}
