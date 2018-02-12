package Medium;

import java.util.*;

public class Permutations {
    boolean[] mask;
    List<Integer> stack;
    int len;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        stack = new LinkedList<Integer>();
        len = nums.length;
        res = new LinkedList<List<Integer>>();
        mask = new boolean[nums.length];
        input(stack, nums);
        return res;
    }

    private void input(List<Integer> stack,int nums[]) {
        if (stack.size() == nums.length) {
            List<Integer> ans = new LinkedList<Integer>();
            listCopy(stack, ans);
            res.add(ans);
        }
        for (int i = 0; i < mask.length; i++) {
            if (!mask[i]) {
                mask[i] = true;
                stack.add(nums[i]);
                input(stack, nums);
                stack.remove(stack.size() - 1);
                mask[i] = false;
            }
        }
    }

    private void listCopy(List<Integer> source, List<Integer> destination) {
        for (Integer ele: source) {
            destination.add(ele);
        }
    }
}
