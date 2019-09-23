package _58tc0916;

import java.util.Arrays;
import java.util.Scanner;

public class No1 {
/*
 * 最长连续子序列长度（最多改变一个数）
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
	    while (sc.hasNext()) {
	        int n = sc.nextInt();
	        int[] a=new int[n+2];//分别为序列的首尾留一位，下面输入时起始赋值是a[1],结束是a[n],所以a[0],a[n+1]会被默认初始化为0，即a[0]=0,a[n+1]=0
	        for (int i=1;i<=n;i++){
	            a[i]=sc.nextInt();
	        }
	        int[] left = new int[n+1];//记录正序遍历找出递增的各个子序列长度
	        int[] right = new int[n+2];//记录逆序遍历找出递增的各个子序列长度
	        for (int i=1;i<=n;i++){//正向统计连续递增序列的长度（以第i位数结尾的递增子序列）
	            left[i] = a[i-1]<a[i]?left[i-1]+1:1;//i=1时，a[0]=0<1<=a[1](因为要求数据1 ≤ a_i ≤ 10^9)，left[0]默认初始化为0，则left[1]=1
	        }
	        for (int j=n;j>0;j--){//逆向统计连续递增序列的长度（以第i位数开始的递增子序列）
	            right[j] = a[j]<a[j+1]?right[j+1]+1:1;//j=n时，a[n]>=1>a[n+1]=0，right[n+1]默认初始化为0，则right[n]=1
	        }
	        int result=1;//最小的序列长度为1，所以把result初始化为1
	        for(int i=1;i<=n;i++){//加1是算上第i位数的长度.对于每一位置i有左侧到它最长的连续子序列长度left[i] 右侧有连续递增子序列长度right[i]
	            //此处是为了比较result、left[i-1]+1、right[i+1]+1的最大值，并赋给result
	            result=Math.max(result,left[i-1]+1);
	            result=Math.max(result,right[i+1]+1);
	            if(a[i+1]-a[i-1]>=2){//第i+1位与第i-1位至少相差2位，则可以修改第i位数，使第i-1、i、i+1也可以组成连续递增序列。
	                result = Math.max(result,left[i-1]+right[i+1]+1);//查找两个和的最大值
	            }
	        }
	        System.out.println(result);
	    }
        
	}

}
