package Hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        TreeNode cur = root;
        TreeNode last =null;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (last == node.right) {
                last = node;
                res.add(node.val);
                continue;
            } else if (last == node.left) {
                if (node.right == null) {
                    res.add(node.val);
                    last = node;
                    continue;
                }
                stack.push(node);
                cur = node.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                    last = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _145 test = new _145();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(test.postorderTraversal(node1));
    }
}
