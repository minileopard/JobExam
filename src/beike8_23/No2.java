package beike8_23;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n , k ;
//		Scanner in = new Scanner(System.in);
//		n = in.nextInt();
//		k = in.nextInt();
//		String t = in.next();
		int n = 3, k = 4;
		String t = "ab";
		System.out.println(find(n, k, t));
		
	}
	public static String find(int n, int k, String t)
	{
		String s = t;
		int tlen = t.length(), end = 0;
		for(int start =  tlen - 1; end < tlen; end++ , start--)
		{
			if(!t.subSequence(0, end + 1).equals(t.subSequence(start, tlen)))
			{
				break;
			}
		}
		for(int i = 1; i < k; i++)
			
			
		{
			s += t.substring(end, tlen);
		}
		return s;
	}
}
