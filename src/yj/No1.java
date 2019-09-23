package yj;

import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		int innum = input.length();
		input = input.substring(1, innum - 1);
		String[] ss= input.split(",");
		int snum = ss.length;
		int nums[] = new int[snum];
		for(int i = 0; i < snum; i++)
		{
			nums[i] = Integer.parseInt(ss[i]);
		}
		int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        System.out.println(res);
	}

}
