package lls;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int yhnum = in.nextInt();
		int ck1 = in.nextInt();
		int ck2 = in.nextInt();
		int nums[][] = new int[yhnum][2];
		for(int i = 0; i < yhnum; i++)
		{
			nums[i][0] = in.nextInt();
			nums[i][1] = in.nextInt();
		}
		in.close();
	}

}
