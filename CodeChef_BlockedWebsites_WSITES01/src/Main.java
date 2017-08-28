import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Sarthak Goyal
 * 08-May-2017 9:37:58 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int N = Reader.nextInt();	//no. of sites on network
			
			String check = "codechef";
			Trie myTrie = new Trie();
			myTrie.Add(check, true);
			myTrie.Add("hello", true);
			myTrie.Add("shit", false);
			myTrie.Add("codeforces", false);
			myTrie.Add("codeforce", false);
			myTrie.Add("codech", false);
			System.out.println("child1 (c) :  " + myTrie.getRoot().getChild().getData() + myTrie.getRoot().getChild().getUnblocked());
			System.out.println("child1 (cbhai) :  " + myTrie.getRoot().getChild().getBrother().getData() + myTrie.getRoot().getChild().getBrother().getUnblocked());
			System.out.println("child1 (hbhai) :  " + myTrie.getRoot().getChild().getBrother().getBrother().getData() + myTrie.getRoot().getChild().getBrother().getBrother().getUnblocked());
			System.out.println("child2 (o) :  " + myTrie.getRoot().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getUnblocked());
			System.out.println("child3 (d) :  " + myTrie.getRoot().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getUnblocked());
			System.out.println("child4 (e) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.print("child5 (c) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.println("    brother of (c) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getUnblocked());
			System.out.print("child6 (h) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.println("    child of (f) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getUnblocked());
			System.out.print("child7 (e) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.println("    child of (o) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getUnblocked());
			System.out.print("child8 (f) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.println("    child of (r) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getUnblocked());
			System.out.println(" \t\t   child of (c) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.println(" \t\t   child of (c) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getChild().getData() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getChild().getUnblocked());
			System.out.println(" \t\t   child of (e) :  " + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getChild().getChild().getLeaf() + myTrie.getRoot().getChild().getChild().getChild().getChild().getChild().getBrother().getChild().getChild().getChild().getChild().getChild().getUnblocked());
			
			// algo to print the final ans
			Stack myStack = new Stack();
			
			Node tmp = myTrie.getRoot();
			myStack.push(tmp);
			String finalans = "";
			String ans = "";
			while(!myStack.isEmpty()) {
				if (tmp.getChild() == null) {
					
				} else {
					if (tmp.getChild().getUnblocked() == true) {
						tmp = tmp.getChild();
						myStack.push(tmp);
						ans = ans + tmp.getData();
					} else {
						ans = ans + tmp.getData();
						finalans = finalans + ans + " ";
						ans = "";
						
					}
				}
			}
			
			
	
			
			
			
			
			
			
			
			
			
//			System.out.println("codechef : " +  myTrie.isMember("codechef"));
//			System.out.println("codech : " + myTrie.isMember("codech"));
//			System.out.println("codeche : " + myTrie.isMember("codeche"));
//			System.out.println("codeforces : " + myTrie.isMember("codeforces"));
//			System.out.println("codec : " + myTrie.isMember("codec"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


class Trie
{
	Node root;
	
	public Trie() {
		root = new Node();
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public void Add(String input, boolean unblocked) {
		Node tmp = root;
		for (int i = 0; i < input.length(); i++) {
			char val = input.charAt(i);
			Node addend = new Node(val);		// Node to add
			addend.setUnblocked(unblocked);
			if (i == input.length() - 1) {
				addend.setLeaf(true);
			}
			Node tmp2 = tmp.getChild();
			if (tmp2 == null) {
				tmp.setChild(addend);
			} else if (tmp2.getData() == val) {
				boolean result = tmp2.getUnblocked() || addend.getUnblocked();
				addend = tmp2;
				addend.setUnblocked(result);
				if (i == input.length() - 1) {
					addend.setLeaf(true);
				}
			} else {
				if (tmp2.getBrother() == null) {
					tmp2.setBrother(addend);
				} 
				while (tmp2.getBrother() != null) {
					 if (tmp2.getBrother().getData() == val){
						boolean result2 = tmp2.getBrother().getUnblocked() || addend.getUnblocked();
						addend = tmp2.getBrother();
						addend.setUnblocked(result2);
						break;
					}
					tmp2 = tmp2.getBrother();
					if (tmp2.getBrother() == null) {
						tmp2.setBrother(addend);
						break;
					}
				}	//while close
			}
			tmp = addend;
		}//'for' close
	}
	
	public boolean isMember(String string) {
		if (root.getChild() == null) {
			return false;
		}
		
		Node tmp = root;
		for (int i = 0; i < string.length(); i++) {
			char val = string.charAt(i);
			Node child = tmp.getChild();
			if (child == null) {
				return false;
			}
			if (child.getData() == val){
				tmp = child;
			} else {
				if (tmp.getBrother() == null) {
					return false;
				} else {
					Node brother = tmp.getBrother();
					while (brother != null) {
						if (brother.getData() == val) {
							tmp = brother;
							break;
						} else if (brother.getBrother() == null) {
								return false;
							}
						}
						brother = brother.getBrother();
					}
				}
			} // for close
		return true;
	}
}


class Stack
{
	protected Node top;
	public int size;
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void push(Node nptr2){
		nptr2.setStackLink(top);
		top = nptr2;
		size++;
	}
	
	public char pop() {
		char d = top.getData();
		top = top.getStackLink();
		size--;
		return d;
	}
	
	public char peek() {
		char d = top.getData();
		return d;
	}
	
}




class Node2 {
	char data;
	Node2 link;

	public Node2() {
		data = '\u0000';
		link = null;
	}
	public Node2 (char data) {
		this.data = data;
		this.link = null;
	}
	public Node2(char data, Node2 link) {
		this.data = data;
		this.link = link;
	}
	public void setLink(Node2 node) {
		this.link = node;
	}
	
	
	public void setData(char data1) {
		this.data = data1;
	}
	public Node2 getLink() {
		return link;
	}
	public char getData() {
		return data;
	}
}



class Node
{
	char data;
	Node brother;
	Node child;
	boolean leaf;
	boolean unblocked;
	Node stackLink;
	
	public Node() {
		this.data = '\u0000';
		this.brother = null;
		this.child = null;
		this.leaf = false;
		this.unblocked = true;
	}
	
	public Node(char data) {
		this.data = data;
		this.brother = null;
		this.child = null;
		this.leaf = false;
		this.unblocked = true;
	}
	
	public Node(char data, boolean l2) {
		this.data =data;
		this.brother = null;
		this.child = null;
		this.leaf = l2;
		this.unblocked = true;
	}
	
	public void setStackLink(Node link) {
		this.stackLink = link;
	}
	public Node getStackLink() {
		return this.stackLink;
	}
	
	public boolean getUnblocked() {
		return this.unblocked;
	}
	
	public void setUnblocked(boolean status) {
		unblocked = status;
	}
	
	public char getData() {
		return this.data;
	}
	
	public void setData(char data) {
		this.data = data;
	}
	
	public void setBrother(Node link) {
		this.brother = link;
	}
	
	public void setChild(Node link) {
		this.child = link;
	}
	
	public Node getBrother() {
		return this.brother;
	}
	
	public Node getChild() {
		return this.child;
	}
	
	public boolean getLeaf() {
		return this.leaf;
	}
	
	public void setLeaf(boolean l2) {
		this.leaf = l2;
	}
}





//Class for buffered reader reading int and double values.
class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	
	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(
					new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}
	
	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO and check for eof if necessary
			tokenizer = new StringTokenizer(
					reader.readLine() );
		}
		return tokenizer.nextToken();
	}
	
	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}
	
	static double nextDouble() throws IOException {
		return Double.parseDouble(next() );
	}
	static String nextString() throws IOException {
		return reader.readLine();
	}
	
	static long nextLong() throws IOException {
		return Long.parseLong( next() );
	}
	
	static String[] nextStringarray() throws IOException {
		return reader.readLine().split(" ");
	}
	
}

