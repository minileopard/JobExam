package _58tc0916;

import java.util.Arrays;
import java.util.Scanner;

public class No1 {
/*
 * ����������г��ȣ����ı�һ������
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
	    while (sc.hasNext()) {
	        int n = sc.nextInt();
	        int[] a=new int[n+2];//�ֱ�Ϊ���е���β��һλ����������ʱ��ʼ��ֵ��a[1],������a[n],����a[0],a[n+1]�ᱻĬ�ϳ�ʼ��Ϊ0����a[0]=0,a[n+1]=0
	        for (int i=1;i<=n;i++){
	            a[i]=sc.nextInt();
	        }
	        int[] left = new int[n+1];//��¼��������ҳ������ĸ��������г���
	        int[] right = new int[n+2];//��¼��������ҳ������ĸ��������г���
	        for (int i=1;i<=n;i++){//����ͳ�������������еĳ��ȣ��Ե�iλ����β�ĵ��������У�
	            left[i] = a[i-1]<a[i]?left[i-1]+1:1;//i=1ʱ��a[0]=0<1<=a[1](��ΪҪ������1 �� a_i �� 10^9)��left[0]Ĭ�ϳ�ʼ��Ϊ0����left[1]=1
	        }
	        for (int j=n;j>0;j--){//����ͳ�������������еĳ��ȣ��Ե�iλ����ʼ�ĵ��������У�
	            right[j] = a[j]<a[j+1]?right[j+1]+1:1;//j=nʱ��a[n]>=1>a[n+1]=0��right[n+1]Ĭ�ϳ�ʼ��Ϊ0����right[n]=1
	        }
	        int result=1;//��С�����г���Ϊ1�����԰�result��ʼ��Ϊ1
	        for(int i=1;i<=n;i++){//��1�����ϵ�iλ���ĳ���.����ÿһλ��i����ൽ��������������г���left[i] �Ҳ����������������г���right[i]
	            //�˴���Ϊ�˱Ƚ�result��left[i-1]+1��right[i+1]+1�����ֵ��������result
	            result=Math.max(result,left[i-1]+1);
	            result=Math.max(result,right[i+1]+1);
	            if(a[i+1]-a[i-1]>=2){//��i+1λ���i-1λ�������2λ��������޸ĵ�iλ����ʹ��i-1��i��i+1Ҳ������������������С�
	                result = Math.max(result,left[i-1]+right[i+1]+1);//���������͵����ֵ
	            }
	        }
	        System.out.println(result);
	    }
        
	}

}
