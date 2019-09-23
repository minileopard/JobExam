import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HamiltonCircuit {
	/*
	 * 
	 * ������s��t�����·����ʹ���ڽӱ�����ڽӾ���ķ�����ʾͼ��
���ݣ�
5 4
1 2
2 3
4 2
5 2
1 3
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();//�����
		int S = input.nextInt();//����
		int matrix[][] = new int[N][N];//�ڽӾ���Ĭ��ֵΪ0
		//���ڽӾ����ʾͼ
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
		//����Ԥ����
		HamiltonCircuit test = new HamiltonCircuit();
        test.getHamiltonCircuit(matrix, startNode, endNode);
	} 
	/*
     * ����adjMatrix������ͼ���ڽӾ�������ֵΪ1��ʾ�������������ͨ��ֵΪ-1��ʾ�������㲻����ͨ
     */
    public void getHamiltonCircuit(int[][] adjMatrix, int startnode, int endnode) {
        boolean[] used = new boolean[adjMatrix.length];       //���ڱ��ͼ�ж����Ƿ񱻷���
        int[] path = new int[adjMatrix.length];       //��¼���ܶٻ�··��
        for(int i = 0;i < adjMatrix.length;i++) {
            used[i] = false;     //��ʼ�������ж����δ������
            path[i] = -1;        //��ʼ����δѡ����㼰�����κζ���
        }
        used[0] = true;          //��ʾ�ӵ�1�����㿪ʼ����
        path[0] = startnode;             //��ʾ���ܶٻ�·���Ϊ��0������
        dfs(adjMatrix, path, used, 1, endnode);     //�ӵ�0�����㿪ʼ����������ȱ���,������ڹ��ܶٻ�·�����һ����·�����������
        //���Ҳ���·���ϵĽ��
        
    }
    /*
     * ����step:��ǰ���ߵĲ��������Ѿ���������ĸ���
     */
    public boolean dfs(int[][] adjMatrix, int[] path, boolean[] used, int step, int endNode) {
		if(path[step - 1] == endNode) {     //�Ѿ��ҵ�endNode
        	for(int i = 0;i < path.length;i++)
                System.out.print(path[i]+"����>");
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
                        used[i] = false;    //���л��ݴ���
                        path[step] = -1;
                    }
                }
            }
        }
        return false;
    }
}
