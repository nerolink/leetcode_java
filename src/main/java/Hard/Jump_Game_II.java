package Hard;

import java.util.*;

public class Jump_Game_II {
    public int jump(int[] nums) {
        Set<Integer> set1 = new LinkedHashSet<Integer>();
        Set<Integer> set2 = new LinkedHashSet<Integer>();
        int step = 0;
        set1.add(0);
        while (!set1.isEmpty()) {
            Iterator<Integer> iterator = set1.iterator();
            while (iterator.hasNext()) {
                int index = iterator.next();
                if (index >= nums.length - 1) {
                    return step;
                }
                if (index + nums[index] >= nums.length - 1) {
                    return step + 1;
                }
                for (int i = nums[index]; i>=1 ; i--) {
                    set2.add(index + i);
                }
            }
            set1 = set2;
            set2 = new HashSet<Integer>();
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        Jump_Game_II test = new Jump_Game_II();
        System.out.println(test.jump(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1,1,0}));
    }
}
