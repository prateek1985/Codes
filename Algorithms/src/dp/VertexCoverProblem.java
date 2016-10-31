package dp;
/*A vertex cover of an undirected graph is a subset 
 * of its vertices such that for every edge (u, v) of the graph, either ‘u’ or ‘v’
 * is in vertex cover. 
 * Although the name is Vertex Cover, the set covers all edges of the given graph.
 */
public class VertexCoverProblem {	

	public static void main(String args[]) throws Exception{
		BTNode root = new BTNode(20);
		root.left               = new BTNode(8);
	    root.left.left          = new BTNode(4);
	    root.left.right         = new BTNode(12);
	    root.left.right.left    = new BTNode(10);
	    root.left.right.right   = new BTNode(14);
	    root.right              = new BTNode(22);
	    root.right.right        = new BTNode(25);
	    ///////////////////////////////////////////////////
	    
	    System.out.println(vertexCover(root));
	    
	}
	private static int vertexCover(BTNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 0;
		// If vertex cover for this node is already evaluated, then return it
		if(root.VCSize != 0)
			return root.VCSize;
		
		int incRoot = 0, excRoot=0;
		 // Calculate size of vertex cover when root is part of it
		incRoot = 1 + vertexCover(root.left) + vertexCover(root.right);
		
		// Calculate size of vertex cover when root is not part of it
		if(root.left!=null)
			excRoot += 1 + vertexCover(root.left.left) + vertexCover(root.left.right);
		
		if(root.right!=null)
			excRoot += 1 + vertexCover(root.right.left) + vertexCover(root.right.right);
		
		root.VCSize = Math.min(incRoot, excRoot);
		
		return root.VCSize;
	}
}
class BTNode{
	
	int VCSize = 0;
	BTNode left =null;
	BTNode right=null;
	int data;
	public BTNode(int data){
		this.data = data;
	}
}

