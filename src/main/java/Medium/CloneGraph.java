package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CloneGraph {
      class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
    Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        stack.push(node);
        return dfs(node);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode u : node.neighbors) {
            if (!stack.contains(u)) {
                stack.push(u);
                res.neighbors.add(dfs(u));
                stack.pop();
            } else if (u.equals(node)) {
                res.neighbors.add(res);
            }
        }
        return res;
    }

}
