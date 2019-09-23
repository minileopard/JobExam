import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HamiltonCircuit {
	/*
	 * 
	 * 求出结点s到t的最长的路径，使用邻接表或者邻接矩阵的方法表示图。
数据：
5 4
1 2
2 3
4 2
5 2
1 3
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//处理输入
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();//结点数
		int S = input.nextInt();//边数
		int matrix[][] = new int[N][N];//邻接矩阵默认值为0
		//用邻接矩阵表示图
		for(int i = 0; i < S; i++)
		{
			int sn = input.nextInt();
			int en = input.nextInt();
			matrix[sn - 1][en - 1] = 1;
			matrix[en - 1][sn - 1] = 1;
		}
		int startNode = input.nextInt() - 1;
		int endNode = input.nextInt() - 1;
		input.close();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		//数据预处理
		HamiltonCircuit test = new HamiltonCircuit();
        test.getHamiltonCircuit(matrix, startNode, endNode);
	} 
	/*
     * 参数adjMatrix：给定图的邻接矩阵，其中值为1表示两个顶点可以相通，值为-1表示两个顶点不能相通
     */
    public void getHamiltonCircuit(int[][] adjMatrix, int startnode, int endnode) {
        boolean[] used = new boolean[adjMatrix.length];       //用于标记图中顶点是否被访问
        int[] path = new int[adjMatrix.length];       //记录哈密顿回路路径
        for(int i = 0;i < adjMatrix.length;i++) {
            used[i] = false;     //初始化，所有顶点均未被遍历
            path[i] = -1;        //初始化，未选中起点及到达任何顶点
        }
        used[0] = true;          //表示从第1个顶点开始遍历
        path[0] = startnode;             //表示哈密顿回路起点为第0个顶点
        dfs(adjMatrix, path, used, 1, endnode);     //从第0个顶点开始进行深度优先遍历,如果存在哈密顿回路，输出一条回路，否则无输出
        //查找不在路径上的结点
        
    }
    /*
     * 参数step:当前行走的步数，即已经遍历顶点的个数
     */
    public boolean dfs(int[][] adjMatrix, int[] path, boolean[] used, int step, int endNode) {
		if(path[step - 1] == endNode) {     //已经找到endNode
        	for(int i = 0;i < path.length;i++)
                System.out.print(path[i]+"——>");
            System.out.println();
                return true;
        }
        else {
            for(int i = 0;i < adjMatrix.length;i++) {
                if(!used[i] && adjMatrix[path[step - 1]][i] == 1) {
                    used[i] = true;
                    path[step] = i;
                    if(dfs(adjMatrix, path, used, step + 1, endNode))
                        return true;
                    else {
                        used[i] = false;    //进行回溯处理
                        path[step] = -1;
                    }
                }
            }
        }
        return false;
    }
}
