package Hard;

public class _135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] nums = new int[ratings.length];
        int sum = 0;
        for (int i = 0; i < ratings.length-1; i++) {
           if (ratings[i]>ratings[i+1]) {
                int t = i+1;
                while (t<ratings.length-1&&ratings[t] > ratings[t + 1]) {
                    t++;
                }
                int diff = t - i;
                for (int j = 0; j <=diff ; j++) {
                    nums[i + j] = diff - j;
                }
               if (i > 0 && ratings[i - 1] < ratings[i]) {
                   nums[i] = Math.max(nums[i - 1] + 1, nums[i]);
               }
                i = t;
            }else  if (i>0&&ratings[i - 1] < ratings[i]) {
               nums[i] = nums[i - 1] + 1;
           }
        }
        if (ratings[ratings.length - 1] > ratings[ratings.length - 2]) {
            nums[ratings.length - 1] = nums[ratings.length - 2] + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum + ratings.length;
    }

    public static void main(String[] args) {
        _135 test = new _135();
        System.out.println(test.candy(new int[]{ 5,3,1}));
    }
}
