package Medium;

public class Jump_Game {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length-2; i>=0 ; i--) {
            if (nums[i]+i>=last)
                last = i;
        }
        return last == 0;
    }

    public static void main(String[] args) {
        Jump_Game test = new Jump_Game();
    }
}
