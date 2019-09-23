import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class test0905_2 {
/*
 * ����������
 * ����ע��������������������µ����봦�����⣡��
 * while(!(temp = in.nextLine()).equals(""))
 * ��һ�лس�֮����ܹ�����
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Scanner in = new Scanner(System.in);
		List<String> inputLines = new ArrayList<String>();
		String temp;
		while(!(temp = in.nextLine()).equals("")) {
			inputLines.add(temp);
		};
		in.close();
		int row = inputLines.size(), col = inputLines.get(0).split(",").length;
		System.out.println(row + " " + col);
		int[][] grid = new int[row][col];
		for(int i = 0; i < row; i++)
		{
			String[] temps = inputLines.get(i).split(",");
			for(int j = 0; j < col; j++)
			{
				grid[i][j] = Integer.parseInt(temps[j]);
			}
		}		
		//�㷨����
		int max = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    int num = deepSearch(grid,i,j);
                    max = Math.max(num,max);
                }
            }
        }
        System.out.println(max);
	}
	public static int deepSearch(int[][] grid,int i,int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j] == 1){
            grid[i][j]=0;
            int num = 1 + deepSearch(grid,i-1,j) + deepSearch(grid,i+1,j) + deepSearch(grid,i,j-1) + deepSearch(grid,i,j+1);
            return num;
        }else
            return 0;
    }
}
//int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//{0,0,0,0,0,0,0,1,1,1,0,0,0},
//{0,1,1,0,1,0,0,0,0,0,0,0,0},
//{0,1,0,0,1,1,0,0,1,0,1,0,0},
//{0,1,0,0,1,1,0,0,1,1,1,0,0},
//{0,0,0,0,0,0,0,0,0,0,1,0,0},
//{0,0,0,0,0,0,0,1,1,1,0,0,0},
//{0,0,0,0,0,0,0,1,1,0,0,0,0}};