package Ali8_30;

public class No1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] nums = {{1,2,3,4,5,7,6},{2,1,4,5,7,4},{3,4,5,6,3,6},
//				{2,3,1,4,6,8},{5,6,1,4,6,2},{4,2,4,1,1,6}};
//		int rowlen = nums.length;
//		int collen = nums[0].length;
//		int res = Integer.MAX_VALUE;
//		for(int i = 0; i < collen; i++)
//		{
//			int temp = dfs(nums, 0, i, rowlen, collen, 0);
//			if(res > temp)
//				res = temp;
//			System.out.println("temp:" + temp);
//		}
//		System.out.println(res);
		long a = 1;
		for(int i = 5; i <=2016; i++)
		{
			a = a * i;
			System.out.println(a);
		}
		
	}
	public static int dfs(int[][] nums, int row, int col, int rowlen, int collen, int sum)
	{
		System.out.println("row:" + row + " col:" + col );
		if(row >= rowlen)
		{
			return sum;
		}
		int tempR = 0, tempD = 0;
		if(row + 1 < rowlen)
			tempD =  dfs(nums, row + 2, col, rowlen, collen, sum + nums[row + 1][col]);
		if(col + 1 < collen)
			tempR =  dfs(nums, row, col + 2, rowlen, collen, sum + nums[row][col + 1]);
		return Math.min(tempR, tempD);
	}

}
