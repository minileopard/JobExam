package pdd_8_11;

import java.util.Scanner;

public class test0904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		//输入
		Scanner in = new Scanner(System.in);
		int M= in.nextInt();
		int N = in.nextInt();
		int nums[] = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++)
		{
			nums[i] = in.nextInt();
			sum += nums[i];
		}
		in.close();
		//算法过程
		if( N == 0 )
		{
			System.out.println(0);
		}
		int res = dfs(nums, M, N, sum, 0);
		System.out.println(res);
	}
	public static int dfs(int[]nums,int m, int n, int sum, int start)
	{
		if(m == 1)
		{
			return sum;
		}
		int min = Integer.MAX_VALUE;
		for(int i = start; i <= n - m + start; i++)
		{
			int leftsum = 0;
			for(int j = start; j <= i; j++)
				leftsum += nums[j];
			leftsum = Math.max(leftsum, dfs(nums, m - 1, n + start - i - 1, sum - leftsum, i+1));
			min = Math.min(min, leftsum);
		}
		return min;
		
	}

}
