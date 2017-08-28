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
 * 10-Apr-2017 6:06:58 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while(T-- > 0){
				int N = Reader.nextInt();
				int K = Reader.nextInt();
				boolean[] boolarray = new boolean[K+1];
				boolarray[0] = true;
				for (int i = 1; i < boolarray.length; i++) {
					boolarray[i] = false;
				}
				Node input = new Node();
				Node head = input;
				for (int i = 0; i < N; i++) {
					int l = Reader.nextInt();	//no. of ingredients on the island
					Node inp1 = new Node(l);
					for (int j = 0; j < l; j++) {
						int data = Reader.nextInt();
						inp1.setArrayData(j, data);
						if (data <= K) {
							boolarray[data] = true;
						}
					}
					input.setLink(inp1);
					input = input.getLink();
				}
				head = input.getLink();		//contains all the data of ingredients in islands
				
				boolean cond = true;
				for (int i = 0; i < boolarray.length; i++) {
					if (boolarray[i] == false){
						cond = false;
						break;
					}
				}
				
				String finalans = "";
				if (cond) {
					//check for all
					Node tmp = head;
					boolean cond2 = false;
					boolean[] array2 = new boolean[K+1];
					array2[0] = true;
					while (tmp != null) {
						int len = tmp.getLength();
						if (len >= K) {
							for (int i = 0; i < len; i++) {
								int data2 = tmp.getArrayData(i);
								if (data2 <= K) {
									array2[data2] = true;
								}
							}
							
							boolean cond3 = true;
							for (int j = 0; j < array2.length; j++) {
								if (array2[j] == false) {
									cond3 = false;
									break;
								}
							}
							
							if (cond3) {
								cond2 = true;
								break;
							}
						}
					tmp = tmp.getLink();
					}
					
					if (cond2) {
						finalans = "some";
					} else {
						Node tmp2 = head;
						
						
						
						
						
					}
				} else {
					finalans = "sad";
				}
				
				
				
				
				System.out.println(finalans);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Node {
	int length;
	int[] array;
	Node link;
	
	public Node() {
		length = 0;
		array = new int[0];
		link = null;
	}
	
	public Node(int length) {
		this.length = length;
		array = new int[length];
		link = null;
	}
	
	public Node(int length, Node next) {
		this.length = length;
		array = new int[length];
		link = next;
	}
	
	public void setLink(Node link) {
		this.link = link;
	}
	
	public Node getLink() {
		return this.link;
	}
	
	public void setArrayData (int index, int data) {
		this.array[index] = data;
	}
	
	public int getArrayData (int index) {
		return this.array[index];
	}
	
	public int getLength () {
		return this.length;
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
