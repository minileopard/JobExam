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
	    if(x==1 && y==1)//1��1����
	        return true;
	    else if(x<=0 || y<=0 || x==y)//���������������ڻ��ʵ�˵��
	        return false;
	    else if(x==1 || y==1)//1���κ�������������
	        return true;
	    else
	    {
	        int tmp=0;
	        //ʹ�������жϷ�����������x<y����һ��ѭ���ύ��x��y��λ��
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
	        if(y==1)          //���Լ��Ϊ1,���Ի���
	            return true;
	        else              //���Լ������1�����Բ�����
	            return false;
	 
	    }
	}


}
