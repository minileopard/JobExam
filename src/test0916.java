import java.util.Scanner;

public class test0916 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���룺
		 * 4 100
		 * 100 73 60
		 * 100 89 35
		 * 30 21 30
		 * 10 8 10
		 */
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int budget = input.nextInt();
		int nums[][] = new int[N][3];
		for(int i = 0; i < N; i++)
		{
			nums[i][0] = input.nextInt();
			nums[i][1] = input.nextInt();
			nums[i][2] = input.nextInt();
		}
		////�㷨��1.�ݹ鱩������ 2.��̬�滮01����
		//����һ������
		for(int i = 0; i < N; i++)
		{
			nums[i][1] = nums[i][1] - (nums[i][0]- nums[i][1]);
			System.out.println(nums[i][1]);
		}
		int dp[][] = new int[N + 1][budget + 1];
		//ǰi����Ʒ, Ԥ��Ϊj����������
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= budget ; j++)
			{
				if(j < nums[i - 1][1])//�޷�װ��
				{
					dp[i][j] = dp[i - 1][j];
				}else//����װ��
				{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1][1]] + nums[i - 1][2]);
				}
			}
		}
		System.out.println(dp[N][budget]);
	}

}
