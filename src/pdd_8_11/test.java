package pdd_8_11;

import java.util.Arrays;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int nums[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			nums[i] = in.nextInt();
		}
		in.close();
		if (N <= 1) {
			System.out.println(N);
        }
        int[] test = new int[N];
        test[0] = nums[0];
        int last = 0;
        for (int i = 1; i < N; i++) {
            int left = 0;
            int right = last + 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (test[mid] <= nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            test[left] = nums[i];
            if (left == last + 1) {
                last++;
            }
        }
        last++;
        System.out.println(last);
		
//		int[] dp = new int[nums.length];
//        int len = 0;
//        for (int num : nums) {
//            int i = Arrays.binarySearch(dp, 0, len, num);
//            if (i < 0) {
//                i = -(i + 1);
//            }
//            dp[i] = num;
//            if (i == len) {
//                len++;
//            }
//        }
//        System.out.println(len);


//      int[] dp = new int[nums.length];
//      dp[0] = 1;
//      int maxans = 1;
//      for (int i = 1; i < dp.length; i++) {
//          int maxval = 0;
//          for (int j = 0; j < i; j++) {
//              if (nums[i] >= nums[j]) {
//                  maxval = Math.max(maxval, dp[j]);
//              }
//          }
//          dp[i] = maxval + 1;
//          maxans = Math.max(maxans, dp[i]);
//      }
//      System.out.println(maxans);
	}
}
