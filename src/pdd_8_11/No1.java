package pdd_8_11;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int input[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			input[i] = in.nextInt();
		}
		//�㷨����
		//����
		Arrays.sort(input);
		//��������С�ķ���
		double min = Integer.MAX_VALUE;
		for(int i = 0; i < N - 2; i++)
		{
			double sum = input[i] + input[i+1] + input[i+2];
			sum = sum / 3;
			double fc = Math.pow((input[i] - sum), 2) + Math.pow((input[i+1] - sum), 2) + Math.pow((input[i+2] - sum), 2);
			if(min > fc)
				min = fc;
		}
		//������λС��
		BigDecimal   b  =  new  BigDecimal(min/3);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
	}

}
