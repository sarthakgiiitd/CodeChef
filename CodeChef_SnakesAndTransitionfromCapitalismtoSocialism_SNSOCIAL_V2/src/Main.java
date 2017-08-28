import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 01-Jun-2017 10:54:58 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int n = Reader.nextInt();
				int m = Reader.nextInt();
				int[][] input = new int[n][m];
				for(int i1 = 0; i1 < n; i1++) {
					for (int j1 = 0; j1 < m; j1++) {
						int num = Reader.nextInt();
						input[i1][j1] = num;
					}
				}
				
				if (check(n,m,input)) {
					System.out.println(0);
					continue;
				}
				int max = findMax(n,m, input);	
				// 0 : x-coordinate, // 1 : y-coordinate, // 2 : max value
				queue Q = new queue();
				Enqueue(Q, max, n, m , input);
				
				int ans = m*n;
				while(!Q.isEmpty()) {
//					System.out.println("loop1 loop1 loop1 loop1 loop1");
//					System.out.println("Q---display");
//					Q.display();
					int[][] layers = new int[n][m];
					boolean[][] visited = new boolean[n][m];
					int[] A = Q.dequeue();
					int x = A[0];
					int y = A[1];
					layers[x][y] = 0;
					queue Q2 = new queue();
					Q2.enqueue(A);
					
					while (!Q2.isEmpty()) {
//						System.out.println("loop2 loop2 loop2 loop2 loop2 loop2");
//						System.out.println("Q2---------------------display");
//						Q2.display();
						int[] B = Q2.dequeue();
						int x1 = B[0];
						int y1 = B[1];
						visited[x1][y1] = true;
						if (up(x1,y1,n,m)) {
							int[] index = indexup(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
								int val = valup(x1, y1, n,m,input);
								if (val != max) {
									input[index[0]][index[1]] = max;
									//if (layers[index[0]][index[1]] == 0) {
										layers[index[0]][index[1]] = layers[x1][y1] + 1;
									//}
									Q2.enqueue(index);
								}
							}
						}
						
						if (down(x1,y1,n,m)) {
							int val = valdown(x1, y1, n,m,input);
							int[] index = indexdown(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
									input[index[0]][index[1]] = max;
									//if (layers[index[0]][index[1]] == 0) {
										layers[index[0]][index[1]] = layers[x1][y1] + 1;
									//}
										Q2.enqueue(index);
							}
						}
						
						if (left(x1,y1,n,m)) {
							int val = valleft(x1, y1, n,m,input);
							int[] index = indexleft(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
									input[index[0]][index[1]] = max;
									//if (layers[index[0]][index[1]] == 0) {
										layers[index[0]][index[1]] = layers[x1][y1] + 1;
									//}
									Q2.enqueue(index);
							}
						}
						
						if (right(x1,y1,n,m)) {
							int val = valright(x1, y1, n,m,input);
							int[] index = indexright(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
									input[index[0]][index[1]] = max;
									//if (layers[index[0]][index[1]] == 0) {
										layers[index[0]][index[1]] = layers[x1][y1] + 1;
									//}
									Q2.enqueue(index);
							}
						}
						
						if (upperleft(x1,y1,n,m)) {
							int val = valupperleft(x1, y1, n,m,input);
							int[] index = indexupperleft(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
								input[index[0]][index[1]] = max;
								//if (layers[index[0]][index[1]] == 0) {
									layers[index[0]][index[1]] = layers[x1][y1] + 1;
								//}
								Q2.enqueue(index);
							}
						}
						
						if (upperright(x1,y1,n,m)) {
							int val = valupperright(x1, y1, n,m,input);
							int[] index = indexupperright(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
								input[index[0]][index[1]] = max;
								//if (layers[index[0]][index[1]] == 0) {
									layers[index[0]][index[1]] = layers[x1][y1] + 1;
								//}
								Q2.enqueue(index);
							}
						}
						
						if (downleft(x1,y1,n,m)) {
							int val = valdownleft(x1, y1, n,m,input);
							int[] index = indexdownleft(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
								input[index[0]][index[1]] = max;
								//if (layers[index[0]][index[1]] == 0) {
									layers[index[0]][index[1]] = layers[x1][y1] + 1;
								//}
								Q2.enqueue(index);
							}
						}
						
						if (downright(x1,y1,n,m)) {
							int val = valdownright(x1, y1, n,m,input);
							int[] index = indexdownright(x1,y1,n,m,input);
							if (visited[index[0]][index[1]] == false) {
								visited[index[0]][index[1]] = true;
								input[index[0]][index[1]] = max;
								//if (layers[index[0]][index[1]] == 0) {
									layers[index[0]][index[1]] = layers[x1][y1] + 1;
								//}
								Q2.enqueue(index);
							}
						}
					} // while Q2 ends
					//System.out.println("layers vala matrix......................");
					//print(n,m,layers);
					int max2 = 0;
					for(int k = 0; k < n; k++) {
						for (int l = 0; l < m; l++) {
							int val = layers[k][l];
							if (val > max2) {
								max2 = val;
							}
						}
					}
					if (max2 < ans) {
						ans = max2;
					}
				}// while Q1 ends
				System.out.println(ans);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void print(int n, int m,int[][] matrix) {
		for (int i = 0; i < n; i++) {
			for (int j =0; j < m; j++) {
				int val = matrix[i][j];
				System.out.print(val);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void Enqueue(queue Q, int val, int n, int m, int[][] matrix) {
		int x= 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int val2 = matrix[i][j];
				if (val2 == val) {
					x = i;
					y = j;
					int[] array = new int[2];
					array[0] = x;
					array[1] = y;
					Q.enqueue(array);
				}
				
			}
		}
	}
	
	private static int findMax(int n, int m, int[][] matrix) {
		int val = matrix[0][0];
		int max = val;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int val2 = matrix[i][j];
				if (val2 > max) {
					max = val2;
				}
			}
		}
		return max;
	}
	
	private static boolean check(int n, int m, int[][] matrix) {
		int val = matrix[0][0];
		for(int i =0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int val2 = matrix[i][j];
				if (val2 != val) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean up(int i, int j, int n, int m) {
		if (i - 1 >= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean down(int i, int j, int n, int m) {
		if (i + 1 < n) {
			return true;
		}
		return false;
	}
	
	private static boolean left(int i, int j, int n, int m) {
		if (j - 1 >= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean right(int i, int j, int n, int m) {
		if (j + 1 < m) {
			return true;
		}
		return false;
	}
	
	private static boolean upperleft(int i, int j, int n, int m) {
		if ((i - 1 >= 0) && (j - 1 >= 0)) {
			return true;
		}
		return false;
	}
	
	private static boolean upperright(int i, int j, int n, int m) {
		if ((i - 1 >= 0) && (j + 1 < m)) {
			return true;
		}
		return false;
	}
	
	private static boolean downleft(int i, int j, int n, int m) {
		if ((i + 1 < n) && (j - 1 >= 0)) {
			return true;
		}
		return false;
	}
	
	private static boolean downright(int i, int j, int n, int m) {
		if ((i + 1 < n) && (j + 1 < m)) {
			return true;
		}
		return false;
	}
	

	private static int[] indexup(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i-1;
		array[1] = j;
		return array;
	}
	
	private static int[] indexdown(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i+1;
		array[1] = j;
		return array;
	}
	
	private static int[] indexleft(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i;
		array[1] = j-1;
		return array;
	}
	
	private static int[] indexright(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i;
		array[1] = j+1;
		return array;
	}
	
	private static int[] indexupperleft(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i-1;
		array[1] = j-1;
		return array;
	}
	
	private static int[] indexupperright(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i-1;
		array[1] = j+1;
		return array;
	}
	
	private static int[] indexdownleft(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i+1;
		array[1] = j-1;
		return array;
	}
	
	private static int[] indexdownright(int i, int j, int n, int m, int[][] matrix) {
		int[] array = new int[2];
		array[0] = i+1;
		array[1] = j+1;
		return array;
	}
	

	private static int valup(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i-1][j];
		return val;
	}
	
	private static int valdown(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i+1][j];
		return val;
	}
	
	private static int valleft(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i][j-1];
		return val;
	}
	
	private static int valright(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i][j+1];
		return val;
	}
	
	private static int valupperleft(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i-1][j-1];
		return val;
	}
	
	private static int valupperright(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i-1][j+1];
		return val;
	}
	
	private static int valdownleft(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i+1][j-1];
		return val;
	}
	
	private static int valdownright(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i+1][j+1];
		return val;
	}


}

/* Class queue */
class queue {
	// With references to lecture slides - lec14
	protected Node front;
	protected Node rear;
	public int size;
	
	/* Constructor */
	public queue() {
		rear = null;
		front = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return rear==null;
	}
	
	public int getSize() {
		return size;
	}
	
	//enqueues an element an rear of the queue, redefine rear
	public void enqueue(int[] val) {
		Node nptr = new Node(val, null);
		if (rear == null) {
			front = nptr;
		} else {
			rear.setLink(nptr);
		}
		rear = nptr;
		size++;
	}
	
	//Removes and returns the first element of the queue
	public int[] dequeue() {
		int[] d = front.getData();
		front = front.getLink();
		if (front == null) {
			rear = null;
		}
		size--;
		return d;
	}
	
	//Returns the data in the first element of the stack, without removing it
	public int[] peek() {
		int[] d = front.getData();
		return d;
	}
	
	public void display() {
		if (rear != null) {
			Node tmp = front;
			while (tmp != null) {
				int[] data = tmp.getData();
				System.out.print(data[0] + " " + data[1] + "      ");
				tmp = tmp.getLink();
			}
		}
		
		System.out.println();
	}
}


class Node {
	int[] data;
	Node link;

	public Node (int[] data) {
		this.data = data;
		this.link = null;
	}
	public Node (int data[], Node link) {
		this.data = data;
		this.link = link;
	}
	
	public void setLink(Node node) {
		this.link = node;
	}
	
	public void setData(int data1[]) {
		this.data = data1;
	}
	
	public Node getLink() {
		return link;
	}
	
	public int[] getData() {
		return data;
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



