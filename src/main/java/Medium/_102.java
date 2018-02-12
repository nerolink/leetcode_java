package Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _102 {
   

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
     
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            while (!queue1.isEmpty()) {
                TreeNode tmp = queue1.remove();
                layer.add(tmp.val);
                if (tmp.left != null) {
                    queue2.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue2.add(tmp.right);
                }
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
            res.add(layer);
        }
        return res;
    }
}
