package Medium;

import java.util.LinkedList;
import java.util.List;

class MapSum {
    Node root = new Node('a');
    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        root.insert(key.toCharArray(), -1, val);
    }

    public int sum(String prefix) {
        return root.prefixSum(prefix.toCharArray(), -1);
    }

    class Node{
        int sum = 0;
        int val;
        char c;
        List<Node> next = new LinkedList<>();

        public Node(char c) {
            this.c = c;
        }

        public void insert(char[] array, int index, int val) {
            if (array.length - 1 == index) {
                this.val = val;
            } else {
                Node nextNode = contain(array[index + 1]);
                if (nextNode == null) {
                    nextNode = new Node(array[index + 1]);
                    next.add(nextNode);
                }
                nextNode.insert(array, index + 1, val);
            }
            sum += val;
        }

        public int prefixSum(char[] array, int index) {
            if (array.length - 1 == index) {
                return sum;
            }
            Node nextNode = contain(array[index + 1]);
            if (nextNode == null) {
                return 0;
            }
            return nextNode.prefixSum(array, index + 1);
        }

        private Node contain(char c) {
            for (Node n : next) {
                if (n.c == c) {
                    return n;
                }
            }
            return null;
        }
    }
}
