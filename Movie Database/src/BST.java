import java.io.*;
import java.io.*;
import java.util.Scanner;

/**
 * Binary search tree and add and search the movies that are added to
 * the tree
 * @author jiawen
 *
 */
public class BST {
	/*
	 * the root of the tree
	 */
	private Node root;

	/**
	 * the constructor 
	 */
	public BST () {
		root = null;
	}

	/**
	 * check if the tree is empty
	 * @return		null if tree is empty
	 */
	public boolean isEmpty () {
		return root == null;
	}

	/**
	 * Facade function for add
	 * @param d		movie, the new movie
	 */
	public void add (Movies m) {
		root = add (m, root);
	}

	/**
	 * add the new movie into BST
	 * @param d		movie, the new movie that need to be added
	 * @param tree	Node, the root of the tree
	 * @return		Node, the root of the tree
	 */
	private Node add (Movies d, Node tree) {
		if (tree == null) {
			return new Node (d);
		} else {//check if the movies are in order and if they exist in the tree
			if (d.compareTo(tree.getMovie()) < 0 ) {
				tree.setLeft(add(d, tree.getLeft()));
			} else if (d.compareTo(tree.getMovie()) > 0){
				tree.setRight (add(d, tree.getRight()));
			}

			return tree;
		}
	}

	/**
	 * print the tree in order (facade function for printBST
	 */
	public void printBST () {
		if (isEmpty ()) {
			System.out.println("No items to print");
		} else {
			printBST (root);
		}
	}

	/**
	 * print out the tree
	 * @param n 	the first movie in the tree
	 */
	private void printBST (Node n) {
		//go down left tree
		if (n.getLeft () != null) {
			printBST (n.getLeft());
		} 
		//go down right tree
		System.out.print(n.getMovie() + " ");
		if (n.getRight() != null) {
			printBST (n.getRight());
		}
	}

	/**
	 * facade function for search
	 * @param m		movie, the movie that need to be searched
	 * @return		Node, null if not found, or the found Node in the tree
	 */
	public Node search (Movies m) {
		if (root == null) {
			System.out.println("No items to search.");
			return null;
		} else {
			return search (m, root);
		}
	}

	/**
	 * Search through the tree to find the movie d
	 * @param d		movie, the movie that need to be searched
	 * @param n		Node, the root of the tree
	 * @return		Node, null if not found, or the found Node in the tree
	 */
	private Node search (Movies d, Node n) {
		if (d.compareTo(n.getMovie()) == 0) {
			return n;
		}
		if (d.compareTo(n.getMovie()) < 0) {
			if (n.getLeft() == null) {
				//System.out.println("Item Not Found");
				return null;
			} else {
				return search(d, n.getLeft());
			}
		} else {
			if (n.getRight() == null) {
				//System.out.println("Item Not Found");
				return null;
			} else {
				return search (d, n.getRight());
			}
		}
	}
	
//	/**
//	 * facade function for search
//	 * @param m		movie, the movie that need to be searched
//	 * @return		Node, null if not found, or the found Node in the tree
//	 */
//	public Node search (String m) {
//		if (root == null) {
//			System.out.println("No items to search.");
//			return null;
//		} else {
//			return search (m, root);
//		}
//	}
//	
//	private Node search (String d, Node n) {
//		if (n.getMovie().compareTo(d) == 0) {
//			return n;
//		}
//		if (n.getMovie().compareTo(d) < 0) {
//			if (n.getLeft() == null) {
//				System.out.println("Item Not Found");
//				return null;
//			} else {
//				return search(d, n.getLeft());
//			}
//		} else {
//			if (n.getRight() == null) {
//				System.out.println("Item Not Found");
//				return null;
//			} else {
//				return search (d, n.getRight());
//			}
//		}
//	}

	public String findMin () {
		return findMin(root).getMovie().getTitle();
	}

	private Node findMin (Node n) {
		if (n == null) {
			return null;
		} else if (n.getLeft() == null) {
			return n;
		}
		return findMin (n.getLeft());
	}

	public String findMax () {
		return findMax(root).getMovie().getTitle();
	}

	private Node findMax (Node n) {
		if (n == null) {
			return null;
		} else if (n.getRight() == null) {
			return n;
		}
		return findMax (n.getRight());
	}

	public void remove (String title) {
		if (root == null) {
			System.out.println("No items to remove");
		} else {
			root = remove (title, root);
		}
	}

	private Node remove (String title, Node n) {
		if (n == null) {
			return n;
		} //traverse to node to be remove
		if (title.compareToIgnoreCase(n.getMovie().getTitle()) < 0) {
			n.setLeft(remove(title, n.getLeft()));
		} else if (title.compareToIgnoreCase(n.getMovie().getTitle()) > 0) {
			n.setRight(remove(title, n.getRight()));
		}//two children
		else if (n.getLeft() != null && n.getRight() != null) {
			if ((int) (Math.random() * 2) == 0) {
				n.setMovie(findMax(n.getLeft()).getMovie());
				n.setRight(remove(n.getMovie().getTitle(), n.getRight()));
			} else {
				n.setMovie(findMax(n.getLeft()).getMovie());
				n.setLeft(remove(n.getMovie().getTitle(), n.getLeft()));
			}
		} else { // one child
			if (n.getLeft() != null) {
				n = n.getLeft();
			} else {
				n = n.getRight();
			}
		}
		return n;
	}

	public void writeToFile () {
		writeToFile(root);
	}
	/**
	 * Write to the movie file
	 * @param fileName		the file the movies need to be locate in.
	 */
	public void writeToFile(Node n) {
		Scanner read = new Scanner (System.in);
		try{
			PrintWriter writer = new PrintWriter("movies.txt");
			if (n.getLeft() != null) {

				writeToFile(n.getLeft());
				//n = n.getLeft();
			}
			writer.println(n.getMovie().getTitle() + "/" + n.getMovie().getYear() + "/" 
					+ n.getMovie().getRating() + "/" + n.getMovie().getLength() + "/"
					+ n.getMovie().getSR() + "/" + n.getMovie().getActors() + " ");
			if (n.getRight() != null) {
			
				writeToFile(n.getLeft());
				//n = n.getLeft();
			}
			writer.close();
		}catch (FileNotFoundException a){
			System.out.println("File was not found");
		}
	}
}
