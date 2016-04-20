/**
 * Node Class that store words
 * @author jiawen
 *
 */
public class Node {
	/**
	 * variable for word class
	 */
	private Movies movie;
	/**
	 * the Node left to the word
	 */
	private Node left;
	/**
	 * the Node right to the word
	 */
	private Node right;

	/**
	 * constructor of Node
	 * @param w		the new word that is being added
	 */
	public Node (Movies m) {
		movie = m;
		left = null;
		right = null;			
	}

	/**
	 * get the word in the node
	 * @return		Node, the word 
	 */
	public Movies getMovie () {
		return movie;
	}

	public void setMovie (Movies m) {
		movie = m;
	}
	/**
	 * set the left Node of the word
	 * @param l		Node, the left Node
	 */
	public void setLeft (Node l) {
		left = l;
	}

	/**
	 * get the left Node
	 * @return		Node, the left Node
	 */
	public Node getLeft () {
		return left;
	}

	/**
	 * set the Right Node
	 * @param r		Node, the right Node
	 */
	public void setRight (Node r) {
		right = r;
	}

	/**
	 * get the right Node
	 * @return		Node, the right Node
	 */
	public Node getRight () {
		return right;
	}
}
