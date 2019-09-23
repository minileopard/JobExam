import java.util.Scanner;
import java.util.Stack;
class Node {
	public int data;
	public Node left = null;
	public Node right = null;
	Node(int data) {
		this.data = data;
	}
}
/*
 * ��������̫����
 * �����Ѿ��賿1��03��
 * ������ʵ���˵��������͵ݹ鷽���������������
 * �ҿ����ǵ��еܰ�
 */
public class test0906 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();
//		in.close();
		String input = "7(1,8(,9(1(2(3,4(,5)),6(7,)),3)))";
//		String input = "1(2(3,4(,5)),6(7,))";
		Node root = dfs(input, 0, 1, input.length() - 1);
//		Node root = iteration(input);
		System.out.println();
		printPreOderByRecursion(root);
	}
	//�������������
	private static void printPreOderByRecursion(Node node){
		if (node == null)
			return;
		printPreOderByRecursion(node.left);
		System.out.print(node.data + " ");
		printPreOderByRecursion(node.right);
 
	}
	private static Node dfs(String input, int root, int left, int right)
	{
//		System.out.println("root:" + input.charAt(root) 
//		+ " leftindex:" + left + " left:" + input.charAt(left) 
//		+ " rightindex:" + right + " right:" + input.charAt(right));
		if(root == left && left == right)
		{
			Node rootTree = null;
			if(input.charAt(root) >= '0' && input.charAt(root) <= '9')
				rootTree = new Node(input.charAt(root) - '0');
//			System.out.println("return");
			return rootTree;
		}
		Node rootTree = new Node(input.charAt(root) - '0');
		//����left��rightֵ
		int ro = left + 1, le = ro + 1, ri = right;
		//������
		if(input.charAt(ro) == ',')//������������
		{
			rootTree.left = null;
			ri = ro - 1;
		}else if(input.charAt(ro) == ')')//����������������
		{
			rootTree.left = null;
			rootTree.right = null;
			return rootTree;
		}else //Ϊ���֣�����������
		{
			if(input.charAt(le) == ',')//������Ϊ��������
			{
				le = ro;
				ri = ro;
				rootTree.left = dfs(input, ro, le, ri);
			}
			else if(input.charAt(le) == '(')//���������Զ�εݹ�
			{
				//���ұ߽������
				int i = le + 1;
				int count = 1;
				for(; i <= right - 1; i++)
				{
					if(input.charAt(i) == '(')
					{
						count++;
					}
					else if(input.charAt(i) == ')')
					{
						count--;
					}
					if(count == 0)
						break;
				}
				ri = i;
				rootTree.left = dfs(input, ro, le, ri);
			}
		}
		//������
		ro = ri + 2;
		if(input.charAt(ro) >= '0' && input.charAt(ro) <= '9')//��������Ϊ��
		{
			le = ro + 1;
			if(input.charAt(le) == '(')
			{
				ri = right - 1;
			}else
			{
				le = ro;
				ri = ro;
			}
			rootTree.right = dfs(input, ro, le, ri);
		}else if(input.charAt(ro) == ')')
		{
			rootTree.right = null;
		}
		return rootTree;
	}
	private static Node iteration(String input)
	{
		/*
		 * ��Ҫһ��ջ����������
		 * һ��ջ�û�����char���͵�ÿ�α���������
		 * ���������ǻ�������������������ָ��
		 */
		Stack<Character> s = new Stack<Character>();
		s.push(input.charAt(0));
		Node root = null;
		Node templeft = null;//ÿ�ε�������Ҫ����һ��
		Node tempright = null;
		int i = 0;
		while(++i < input.length())
		{
			if(input.charAt(i) == ')')
			{
				Node tempr = null;
				Node templ = null;
				//���ź���������
				if(s.peek() >= '0' && s.peek() <= '9')//����������
				{
					tempr = new Node(s.peek() - '0');
					s.pop();//pop������
					s.pop();//pop��,
					if(s.peek() >= '0' && s.peek() <= '9')//����������Ϊ����3(3,3)
					{
						templ = new Node(s.peek() - '0');
						s.pop();//pop���������ı�־
					}else if(s.peek() == 'l')//3(l,3)//������Ϊָ��l
					{
						templ = templeft;
						s.pop();//pop���������ı�־
					}
				}
				else if(s.peek() == 'r')//�����������Ǹ��Ѿ����õ���
				{
					tempr = tempright;
					s.pop();//pop��r
					s.pop();//pop��,
					if(s.peek() >= '0' && s.peek() <= '9')//����������Ϊ����3(3,3)
					{
						templ = new Node(s.peek() - '0');
						s.pop();//pop���������ı�־
					}else if(s.peek() == 'l')//3(l,3)//������Ϊָ��l
					{
						templ = templeft;
						s.pop();//pop���������ı�־
					}
				}
				else if(s.peek() == ',')//������������
				{
					s.pop();//pop��,
					if(s.peek() >= '0' && s.peek() <= '9')//����������Ϊ����3(3,3)
					{
						templ = new Node(s.peek() - '0');
						s.pop();//pop���������ı�־
					}else if(s.peek() == 'l')//3(l,3)//������Ϊָ��l
					{
						templ = templeft;
						s.pop();//pop���������ı�־
					}
				}
				s.pop();//ȥ��(
				Node temproot = new Node(s.peek() - '0');
				temproot.left = templ;
				temproot.right = tempr;
				System.out.println("root" + s.peek());
				s.pop();//ȥ��root��ֵ
				root = temproot;
				if(s.empty())
					break;
				if(s.peek() == ',')//Ϊ�ұߵ�����
				{
					tempright = root;
					s.push('r');
				}else//Ϊ��ߵ�����
				{
					templeft = root;
					s.push('l');
				}
			}else
			{
				s.push(input.charAt(i));
			}
			Stack<Character> st = (Stack<Character>) s.clone();
			while(!st.empty())
			{
				System.out.print(st.peek() + " ");
				st.pop();
			}
			System.out.println();
		}
		return root;
	}
}
