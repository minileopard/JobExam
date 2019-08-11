package pdd_8_11;

import java.util.Arrays;
import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//处理输入
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int N = in.nextInt();
		int input[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			input[i] = in.nextInt();
		}
		in.close();
		//算法过程
		//排序
		Arrays.sort(input);
		int input2[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			if(input[i] > L / 2)
			{
				input2[i] = input[i] - L; 
			}
			else 
			{
				input2[i] = input[i];
			}
			
		}
		Arrays.sort(input2);
		for(int i = 0; i < N; i++)
		{
			System.out.print(input2[i] + " ");
		}
		System.out.println();
		int res = Math.min(movesum(input2), movesum(input));
		System.out.println(res);
	}
	public static int movesum(int[] input)
	{
		int mid = input.length / 2;
		int midnum;
		if(input.length % 2 != 0)//奇数
		{
			midnum = input[mid];
		}else//偶数
		{
			midnum = (input[mid] + input[mid - 1]) /2;
		}
		System.out.println("mid" + mid + "midnum:" + midnum);
		int res = 0, aim = midnum;
		for(int i = mid - 1;  i >= 0; i--)
		{
			res += aim - input[i];
			System.out.println("i: "+ i + "res: " + res);
			aim--;
		}
		aim = midnum + 1;
		for(int j = mid; j < input.length; j++)
		{
			res += input[j] - aim;
			aim++;
			System.out.println("j: "+ j + "res: " + res);
		}
		System.out.println();
		return res;
	}
}
