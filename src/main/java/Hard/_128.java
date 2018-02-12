package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> accessed = new HashSet<Integer>();
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            if (accessed.contains(nums[i])) {
                continue;
            }
            accessed.add(nums[i]);
            if (map.get(nums[i] - 1) != null) {
                if (map.get(nums[i] + 1) != null) {
                    int begin = map.get(nums[i] - 1);
                    int end = map.get(nums[i] + 1);
                    map.put(begin, end);
                    map.put(end, begin);
                    maxLen = Math.max(maxLen, end - begin + 1);
                } else {
                    int begin = map.get(nums[i] - 1);
                    map.put(begin, nums[i]);
                    map.put(nums[i], begin);
                    maxLen = Math.max(maxLen, nums[i] - begin + 1);
                }
            } else if (map.get(nums[i] + 1) != null) {
                int end = map.get(nums[i] + 1);
                map.put(nums[i], end);
                map.put(end, nums[i]);
                maxLen = Math.max(end - nums[i] + 1, maxLen);
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        _128 test = new _128();
        System.out.println(test.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
