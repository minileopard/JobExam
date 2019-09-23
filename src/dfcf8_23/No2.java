package dfcf8_23;

public class No2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,15,3,10};
		System.out.println(find(input));
//		/*
//		 * ��͵����һ�ҷ��ӣ���ô���һ�ҷ��ӣ�һ��������͵����
//			��������һ�ҷ��ӣ���͵~��������������һ�ҷ���͵��͵�ǲ�ȷ���ģ���ȡ����һ���ж��ټҷ��ӡ�
//		 */
//		int prevMax = 0;
//	    int currMax = 0;
//	    for (int x : input) {
//	        int temp = currMax;
//	        currMax = Math.max(prevMax + x, currMax);
//	        prevMax = temp;
//	    }
//	    System.out.println(currMax);
		

	}
	public static int find(int[] nums)
	{
		if(nums == null || nums.length == 0) 
            return 0;
        if(nums.length == 1) 
            return nums[0];
        if(nums.length == 2) 
            return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[nums.length];//һ����͵���һ��
        int[] dp2 = new int[nums.length];//һ����͵��һ��
        
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        
        for(int j = 2; j < nums.length-1; j ++){
            dp1[j] = Math.max(dp1[j-2] + nums[j], dp1[j-1]);
        }
        for(int i = 3; i < nums.length; i ++){
            dp2[i] = Math.max(dp2[i-2] + nums[i],dp2[i-1]);
        }
        return Math.max(dp1[nums.length-2],dp2[nums.length-1]);
	}

}
