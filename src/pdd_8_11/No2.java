package pdd_8_11;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//处理输入
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int input[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			input[i] = in.nextInt();
		}
		for(int i = 0; i < N; i++)
		{
			System.out.print(input[i] + " ");
		}
		//算法过程
	}

}
