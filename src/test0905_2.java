import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class test0905_2 {
/*
 * 岛屿最大面积
 * 这里注意输入行数不定的情况下的输入处理问题！！
 * while(!(temp = in.nextLine()).equals(""))
 * 多一行回车之后就能够结束
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//处理输入
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
		//算法过程
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