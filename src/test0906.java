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
 * 我他喵的太难了
 * 现在已经凌晨1：03了
 * 我总算实现了迭代方法和递归方法两种来解这道题
 * 我可能是弟中弟吧
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
	//中序遍历二叉树
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
		//更新left，right值
		int ro = left + 1, le = ro + 1, ri = right;
		//左子树
		if(input.charAt(ro) == ',')//左子树不存在
		{
			rootTree.left = null;
			ri = ro - 1;
		}else if(input.charAt(ro) == ')')//左右子树都不存在
		{
			rootTree.left = null;
			rootTree.right = null;
			return rootTree;
		}else //为数字，左子树存在
		{
			if(input.charAt(le) == ',')//左子树为单个数字
			{
				le = ro;
				ri = ro;
				rootTree.left = dfs(input, ro, le, ri);
			}
			else if(input.charAt(le) == '(')//子树还可以多次递归
			{
				//求右边界的括号
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
		//右子树
		ro = ri + 2;
		if(input.charAt(ro) >= '0' && input.charAt(ro) <= '9')//右子树不为空
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
		 * 需要一个栈和两个缓存
		 * 一个栈用户保存char类型的每次遍历的内容
		 * 两个缓存是缓存左子树和右子树的指针
		 */
		Stack<Character> s = new Stack<Character>();
		s.push(input.charAt(0));
		Node root = null;
		Node templeft = null;//每次的子树需要保存一下
		Node tempright = null;
		int i = 0;
		while(++i < input.length())
		{
			if(input.charAt(i) == ')')
			{
				Node tempr = null;
				Node templ = null;
				//括号后面是数字
				if(s.peek() >= '0' && s.peek() <= '9')//存在右子树
				{
					tempr = new Node(s.peek() - '0');
					s.pop();//pop掉数字
					s.pop();//pop掉,
					if(s.peek() >= '0' && s.peek() <= '9')//存在左子树为数字3(3,3)
					{
						templ = new Node(s.peek() - '0');
						s.pop();//pop掉左子树的标志
					}else if(s.peek() == 'l')//3(l,3)//左子树为指针l
					{
						templ = templeft;
						s.pop();//pop掉左子树的标志
					}
				}
				else if(s.peek() == 'r')//表明右子树是个已经建好的树
				{
					tempr = tempright;
					s.pop();//pop掉r
					s.pop();//pop掉,
					if(s.peek() >= '0' && s.peek() <= '9')//存在左子树为数字3(3,3)
					{
						templ = new Node(s.peek() - '0');
						s.pop();//pop掉左子树的标志
					}else if(s.peek() == 'l')//3(l,3)//左子树为指针l
					{
						templ = templeft;
						s.pop();//pop掉左子树的标志
					}
				}
				else if(s.peek() == ',')//不存在右子树
				{
					s.pop();//pop掉,
					if(s.peek() >= '0' && s.peek() <= '9')//存在左子树为数字3(3,3)
					{
						templ = new Node(s.peek() - '0');
						s.pop();//pop掉左子树的标志
					}else if(s.peek() == 'l')//3(l,3)//左子树为指针l
					{
						templ = templeft;
						s.pop();//pop掉左子树的标志
					}
				}
				s.pop();//去掉(
				Node temproot = new Node(s.peek() - '0');
				temproot.left = templ;
				temproot.right = tempr;
				System.out.println("root" + s.peek());
				s.pop();//去掉root标值
				root = temproot;
				if(s.empty())
					break;
				if(s.peek() == ',')//为右边的子树
				{
					tempright = root;
					s.push('r');
				}else//为左边的子树
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
