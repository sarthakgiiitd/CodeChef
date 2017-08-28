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
 * 12-May-2017 7:39:21 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int N = Reader.nextInt();		//size of the array A
			int K = Reader.nextInt();		//size of frame
			int P = Reader.nextInt();		//no. of requests by dog
			queue myQ = new queue();
			String[] input = Reader.nextStringarray();
			for (int i = N-1; i > -1; i--) {
				String num = input[i];
				int num2 = Integer.parseInt(num);
				myQ.enqueue(num2);
			}
			int exception = 0;
			if (K >= N) {
				exception = frame(myQ, K, N);
			}
			
			String query = Reader.nextString();
			for (int i = 0; i < query.length(); i++) {
				char character = query.charAt(i);
				int charascii = character;
				if (charascii == 63) {
					if (K >= N) {
						System.out.println(exception);
					} else {
						int count = frame(myQ, K, N);
						System.out.println(count);
					}
				} else {
					shift(myQ);
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int frame(queue Q, int K, int N){
		Node tmpfront = Q.front;
		queue frameQ = new queue();
		int count = 0;
		if (K >= N) {
			while (tmpfront != null) {
				int d = tmpfront.getData();
				if (d==1) {
					count++;
				}
				tmpfront = tmpfront.getLink();
			}
			return count;
		}
		
		
		for (int i = 0; i < K; i++) {
			int d = tmpfront.getData();
			if (d == 1) {
				count++;
			}
			frameQ.enqueue(d);
			tmpfront = tmpfront.getLink();
		}
		int maxcount = count;
		while (tmpfront != null) {
			int val = frameQ.dequeue();
			if (val == 1) {
				count--;
			}
			int d2 = tmpfront.getData();
			frameQ.enqueue(d2);
			if (d2 == 1) {
				count++;
			}
			
			if (count > maxcount) {
				maxcount = count;
			}
			tmpfront = tmpfront.getLink();
		}
		return maxcount;
	}
	
	private static void shift(queue Q) {
		int d = Q.dequeue();
		Q.enqueue(d);
	}
}


class queue
{
	protected Node front;
	protected Node rear;
	public int size;
	
	public queue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void enqueue(int data){
		Node nptr = new Node(data);
		if (rear == null) {
			front = nptr;
		} else {
			rear.setLink(nptr);
		}
		rear = nptr;
		size++;
	}
	
	public int dequeue() {
		int d = front.getData();
		front = front.getLink();
		if (front == null) {
			rear = null;
		}
		size--;
		return d;
	}
	
	public int peek() {
		return front.getData();
	}
	
	public void display() {
		if (rear != null) {
			Node tmp = front;
			while (tmp != null) {
				int d = tmp.getData();
				System.out.print(d + " ");
				tmp = tmp.getLink();
			}
		}
		System.out.println();
	}
}


class Node 
{
	int data;
	Node link;
	
	public Node() {
		this.data = -1;
		this.link = null;
	}
	
	public Node(int data) {
		this.data = data;
		this.link = null;
	}
	
	public Node(int data, Node next) {
		this.data = data;
		this.link = next;
	}
	
	public int getData() {
		return this.data;
	}
	
	public Node getLink() {
		return this.link;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLink(Node next) {
		this.link = next;
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
