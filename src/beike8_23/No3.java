package beike8_23;

import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int kind = 4, V = 100;//种类，体积
//		int[] nums = {3,3,1,1};//个数
//		int[] vs = {40,6,1,5};//体积
		//处理输入
		Scanner in = new Scanner(System.in);
		int kind = in.nextInt();
		int V = in.nextInt();
		int res = 0;
		for(int i = 0; i < kind; i++)
		{
			int num = in.nextInt();
			int vi = in.nextInt();
			while(V >= vi && num > 0)
			{
				V = V - vi;
				res++;
				num--;
			}
		}
		in.close();
//		int res = 0;
//		for(int i = 0; i < kind; i++)
//		{
//			int num = nums[i];
//			int vi = vs[i];
//			while(V >= vi && num > 0)
//			{
//				V = V - vi;
//				res++;
//				num--;
//			}
//		}
		System.out.println(res);
		
	}

}
