package yj;

import java.util.Arrays;
import java.util.Scanner;

public class No2 {

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
		
		Arrays.sort(nums);
		if( N % 2 == 0 )
		{
			System.out.println(nums[N/2 - 1]);
		}else
		{
			System.out.println(nums[N/2]);
		}
	}

}
