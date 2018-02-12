package Hard;

public class _99 {
     public static class  TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    private TreeNode node1, node2;
    private TreeNode lastNode;
    private Integer lastValue;
    public void recoverTree(TreeNode root) {
        search(root);
        int tmp = lastNode.val;
        lastNode.val = node2.val;
        node2.val = tmp;
    }

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null) {
            if (lastValue == null) {
                lastValue = node.val;
                lastNode = node;
            } else if (lastValue > node.val) {
                node2 = node;
            } else {
                if (node2 != null) {
                    return;
                }
                lastValue = node.val;
                lastNode = node;
            }
            search(node.right);
        } else {
            search(node.left);
            if (lastValue > node.val) {
                node2 = node;
            } else {
                if (node2 != null) {
                    return;
                }
                lastValue = node.val;
                lastNode = node;
            }
            search(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        node2.right = node1;
        _99 test = new _99();
        test.recoverTree(node2);
        System.out.println(node2.val);
    }
}
