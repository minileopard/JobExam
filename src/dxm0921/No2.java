package dxm0921;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		//构造原矩阵
		int[][] matrix = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				matrix[i][j] = ((i + 1) * (j + 1)) % 10;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		//
		int imax = n - a + 1;
		int jmax = m - b + 1;
		if(a > n && b > m)
		{
			System.out.println(9);
		}else if(a > n)
		{
			imax = 1;
		}else if(b > m)
		{
			jmax = 1;
		}
		int res = 0;
		for(int i = 0; i < imax; i++)
		{
			for(int j = 0; j < jmax; j++)
			{
				//求窗口最大值
				int max = matrix[i][j];
				for(int k = i; k < i + a && k < n; k++)
				{
					for(int l = j; l < j + b && l < m; l++)
					{
						if(matrix[k][l] > max)
							max = matrix[k][l];
					}
				}
				res += max;
			}
		}
		System.out.println(res);
	}

}
