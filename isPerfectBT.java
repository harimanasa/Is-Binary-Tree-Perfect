public class isPerfectBT {
	static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value){
            if(value < this.value){
                if(this.left!=null){this.left.insert(value);}
                else {this.left = new BST(value);}
            }
            else if(value > this.value){
                if(this.right!=null){this.right.insert(value);}
                else {this.right = new BST(value);}
            }
            return this;
        }  
	}
	
    
    public static boolean isPerfectBT(BST tree) {
    	if(tree == null) return true;
    	int height = calcHeight(tree);
    	int expectedNumNodes = (int) (Math.pow(2,height) -1);
    	//System.out.print(expectedNumNodes);
    	//System.out.print(numberOfNodes(tree));

    	return (numberOfNodes(tree) == expectedNumNodes );
    } 

	private static int numberOfNodes(BST tree) {
		if(tree == null) return 0;
		return 1+ numberOfNodes(tree.left)+ numberOfNodes(tree.right);
	}
	
	private static int calcHeight(BST tree) {
		if(tree == null) return 0;
		return 1+ Math.max(calcHeight(tree.left), calcHeight(tree.right));
	}

	public static void main(String[] args) {
		BST tree = new BST(10);
		tree.insert(5).insert(15).insert(2).insert(8).insert(12).insert(20).insert(1).insert(4).insert(7).insert(9).insert(11).insert(13).insert(17).insert(22);
		System.out.println(isPerfectBT(tree));
	}
}

