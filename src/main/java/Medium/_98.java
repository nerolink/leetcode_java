package Medium;

import java.util.LinkedList;
import java.util.List;

public class _98 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private Integer lastValue = null;
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }



    private boolean isValid(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null) {
            if (lastValue!=null&&lastValue >= node.val) {
                return false;
            }
            lastValue = node.val;
            return isValid(node.right);
        } else {
            if (isValid(node.left)) {
                if (lastValue!=null&&node.val <= lastValue) {
                    return false;
                }
                lastValue = node.val;
                return isValid(node.right);
            }
            return false;
        }
    }

    //    private void buildSeq(List<Integer> list,TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node.left == null) {
//            list.add(node.val);
//            buildSeq(list, node.right);
//        } else {
//            buildSeq(list, node.left);
//            list.add(node.val);
//            buildSeq(list, node.right);
//        }
//    }
    public static void main(String[] args) {
        _98 test = new _98();
//        _98.TreeNode root = new _98.TreeNode(10);
//        TreeNode _5 = new TreeNode(5);
//        TreeNode _15 = new TreeNode(15);
//        TreeNode _6 = new TreeNode(6);
//        TreeNode _20 = new TreeNode(20);
//        root.left = _5;
//        root.right = _15;
//        _15.left = _6;
//        _15.right = _20;
//        System.out.println(test.isValidBST(root));
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        node.left = left;
        System.out.println(test.isValidBST(node));
    }
}
