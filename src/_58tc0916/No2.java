package _58tc0916;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//处理输入
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(",");
		in.close();
		int N = input.length;
		int[] nums = new int[N];
		for(int i = 0; i < N; i++)
		{
			nums[i] = Integer.parseInt(input[i]);
		}
		//算法过程
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < N; i++)
		{
			int count = map.getOrDefault(nums[i], 0) + 1;
			map.put(nums[i], count);
		}
		int res = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey() + 1;
			int value = entry.getValue();
			int count = value / key;
			if(value % key != 0)
			{
				count++;
			}
			res += count * key;
			System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
		System.out.println(res);
	}

}
