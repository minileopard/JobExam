package dxm0921;

import java.util.Scanner;

public class No3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int nums[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			nums[i] = sc.nextInt();
		}
		sc.close();
		//
		for(int i = 0; i < N; i++)
		{
			int count = 0, sum = 0;
			for(int k = 0; k < nums[i] - 1; k++)
			{
				for(int l = k + 1; l < nums[i]; l++)
				{
					if(isCoprime(k+1, l+1))
					{
						sum += (k+1)*(l+1);
					}
					count++;
				}
			}
			if(sum%count == 0)
			{
				System.out.println(sum/count);
			}
			else {
				System.out.println(sum + "/" + count);
			}
		}
	}
	public static boolean isCoprime(int x,int y)
	{
	    if(x==1 && y==1)//1和1互质
	        return true;
	    else if(x<=0 || y<=0 || x==y)//非正整数都不存在互质的说法
	        return false;
	    else if(x==1 || y==1)//1和任何正整数都互质
	        return true;
	    else
	    {
	        int tmp=0;
	        //使用求商判断法，如果输入的x<y，第一次循环会交换x和y的位置
	        while(true)
	        {
	            tmp=x%y;
	            if(tmp==0)
	            {
	                break;
	            }
	            else
	            {
	                x=y;
	                y=tmp;
	            }
	        }
	        if(y==1)          //最大公约数为1,所以互质
	            return true;
	        else              //最大公约数大于1，所以不互质
	            return false;
	 
	    }
	}


}
