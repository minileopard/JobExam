import java.util.Arrays;
import java.util.Scanner;

public class test0905 {

	/*
	 * 硬币兑换
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//处理输入
		Scanner in = new Scanner(System.in);
		int M= Integer.parseInt(in.nextLine());//目标钱数目
		String[] tempcoins = in.nextLine().split(" ");
		int coinsize = tempcoins.length;
		int[] coins = new int[coinsize];//硬币数组
		for(int i = 0; i < coinsize; i++)
		{
			coins[i] = Integer.parseInt(tempcoins[i]);
		}
		in.close();
		//动态规划，01背包问题
		int max = M + 1;             
        int[] dp = new int[M + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < coinsize; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        int res =  dp[M] > M ? -1 : dp[M];
        System.out.println(res);
	}

}
