import java.util.ArrayList;

public class IsPerfectBinaryTree {

	static class Node{
		int value;
		Node left, right;
		Node(int value){this.value = value; left = null; right = null;}

		Node insert(int value) {
			if(value<this.value) {
				if(this.left==null) this.left = new Node(value);
				else {this.left.insert(value);}
			}
			else if(value>this.value) {
				if(this.right==null) this.right = new Node(value);
				else {this.right.insert(value);}
			}
			return this;
		}
		
		ArrayList<Integer> inOrder(Node tree) {
			
			return helper(tree, new ArrayList<Integer>());
		}
		
		private ArrayList<Integer> helper(Node tree, ArrayList<Integer> path) {
			if(tree.left!=null) {
				  helper(tree.left, path);
			}
			path.add(tree.value);
			if(tree.right!=null) {
				  helper(tree.right, path);
			}
			return path;
		}
	}	
	
	static boolean isPerfectBinaryTree(Node tree) {
		if (tree.left==null && tree.right == null) {
			return true;
		}
		else if (tree.left!=null && tree.right!=null) {
			return isPerfectBinaryTree(tree.left) && isPerfectBinaryTree(tree.right);
		}
		else {
		return false;
		}
	}
	
	
	public static void main(String[] args) {
		Node tree = new Node(10);
		tree.insert(5).insert(15).insert(2).insert(8).insert(12).insert(20).insert(1).insert(4).insert(7).insert(9).insert(11).insert(13).insert(17).insert(22);
		ArrayList<Integer> path = tree.inOrder(tree);
		//System.out.println(path.size());
		for(int i: path) {System.out.print(i + " ");}
		System.out.println(isPerfectBinaryTree(tree));
	}
}
