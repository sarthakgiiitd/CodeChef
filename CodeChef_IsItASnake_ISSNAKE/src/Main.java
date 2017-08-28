import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 28-May-2017 6:59:11 AM
 * 
 */

public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int n = Reader.nextInt();
				boolean[][] input = new boolean[2][n];	//whereever is black, true
				boolean ans = true;
				String row1 = Reader.nextString();
				String row2 = Reader.nextString();
				for (int q = 0; q < row1.length(); q++) {
					char val = row1.charAt(q);
					if (val == '#') {
						input[0][q] = true;
					}
				}
				for (int w = 0; w < row2.length(); w++) {
					char val = row2.charAt(w);
					if (val == '#') {
						input[1][w] = true;
					}
				}
				
				int countblack = 0;
				int[][] neighbours = new int[2][n];
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < n; j++) {
						int count = 0;
						boolean cond = input[i][j];
						if (cond) {
							countblack++;
							if (i == 0) {
								boolean down = input[i+1][j];
								if (down) {
									count++;
								}
								
								if (n > 1) {
									if (j == 0) {
										boolean right = input[i][j+1];
										if (right) {
											count++;
										}
									} else if (j == n-1) {
										boolean left = input[i][j-1];
										if (left) {
											count++;
										}
									} else {
										boolean left = input[i][j-1];
										boolean right = input[i][j+1];
										if (left) {
											count++;
										}
										
										if (right) {
											count++;
										}
									}
								}
							} else {
								boolean up = input[i-1][j];
								if (up) {
									count++;
								}
								
								if (n > 1) {
									if (j == 0) {
										boolean right = input[i][j+1];
										if (right) {
											count++;
										}
									} else if (j == n-1) {
										boolean left = input[i][j-1];
										if (left) {
											count++;
										}
									} else {
										boolean left = input[i][j-1];
										boolean right = input[i][j+1];
										if (left) {
											count++;
										} 
										
										if (right) {
											count++;
										}
									}
								}
							}
						}
						neighbours[i][j] = count;
						System.out.println("i : " + i + "\t" + "j : " + j + "\t" + count);
//						if (count > 2) {
//							ans = false;
//							break;
//							
//						}
					} // for(j)
//					if (ans == false) {
//						break;
//					}
				} // for (i)
				
//				if (countblack == 1) {
//				 	ans = false;
//				}
//				
//				if (ans == false) {
//					System.out.println("no");
//					continue;
//				}
				
				System.out.println(countblack);
				
				// dfs traversal of the so-called graph
				int startx = 0;
				int starty = 0;
				boolean status = true;
				for (int p = 0; p < 2; p++) {
					for (int r= 0; r < n; r++) {
						boolean cond = input[p][r];
						if (cond) {
							startx = p;
							starty = r;
							status = false;
							break;
						}
					}
					if (status == false) {
						break;
					}
				}
				
				boolean[][] visited = new boolean[2][n];
				visited[startx][starty] = true;
				Stack mystack = new Stack();
				mystack.push(startx,  starty);
				int x = startx; 
				int y = starty;
				while (!mystack.isEmpty()) {
					int[] array = mystack.pop();
					x = array[0];
					y = array[1];
					boolean hasnebour = hasNeighbour(x, y, neighbours);
					if (hasnebour) {
						if (x == 0) {
							boolean down = input[x+1][y];
							if (down) {
								if (!visited[x+1][y]) {
									visited[x+1][y] = true;
									int posx = x+1;
									int posy = y;
									mystack.push(x+1, y);
								}
							}
							
							if (n > 1) {
								if (y == 0) {
									boolean right = input[x][y+1];
									if ((right) && (!visited[x][y+1])) {
										visited[x][y+1] = true;
										int posx = x;
										int posy = y+1;
										mystack.push(x, y+1);
									}
								} else if (y == n-1) {
									boolean left = input[x][y-1];
									if ((left) && (!visited[x][y-1])) {
										visited[x][y-1] = true;
										int posx = x;
										int posy = y-1;
										mystack.push(x, y-1);
									}
								} else {
									boolean left = input[x][y-1];
									boolean right = input[x][y+1];
									if ((left) && (!visited[x][y-1])) {
										visited[x][y-1] = true;
										int posx = x;
										int posy = y-1;
										mystack.push(x, y-1);
									} else if ((right) && (!visited[x][y+1])) {
										visited[x][y+1] = true;
										int posx = x;
										int posy = y+1;
										mystack.push(x, y+1);
									}
								}
							}
							
						} else {
							boolean up = input[x-1][y];
							if (up) {
								if (!visited[x-1][y]) {
									visited[x-1][y] = true;
									int posx = x-1;
									int posy = y;
									mystack.push(x-1, y);
								}
							}
							
							if (n > 1) {
								if (y == 0) {
									boolean right = input[x][y+1];
									if ((right) && (!visited[x][y+1])) {
										visited[x][y+1] = true;
										int posx = x;
										int posy = y+1;
										mystack.push(x, y+1);
									}
								} else if(y == n-1) {
									boolean left = input[x][y-1];
									if ((left) && (!visited[x][y-1])) {
										visited[x][y-1] = true;
										int posx = x;
										int posy = y-1;
										mystack.push(x, y-1);
									}
								} else {
									boolean left = input[x][y-1];
									boolean right = input[x][y+1];
									if ((left) && (!visited[x][y-1])) {
										visited[x][y-1] = true;
										int posx = x;
										int posy = y-1;
										mystack.push(x, y-1);
									} else if ((right) && (!visited[x][y+1])) {
										visited[x][y+1] = true;
										int posx = x;
										int posy = y+1;
										mystack.push(x, y+1);
									}
								}
							}

						}
					} // if (hasnebour)
					
					
					System.out.println("hello");	
				}	// while stack
				
				int countvisited = 0;
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < n; j++ ) {
						if (visited[i][j]) {
							countvisited++;
						}
					}
				}
				
				if (countblack == countvisited) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
				
			} // main while
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean hasNeighbour(int posx, int posy, int[][] neighbour) {
		int num = neighbour[posx][posy];
		if (num > 0) {
			return true;
		}
		return false;
	}
}


class Stack {
	// With references to DSA lecture slides - lec13
	protected Node top;
	public int size;
	//protected Node head = top;
	
	/* Constructor */
	public Stack() {
		top = null;
		size = 0;
	}
	
	//Boolean value returning true for size == 0;
	public boolean isEmpty() {
		return top==null;
	}
	
	//size of the stack
	public int getSize() {
		return size;
	}
	
	//push an element on top of the stack, redefine top
	public void push(int posx, int posy) {
		Node nptr = new Node(posx, posy, null);
		nptr.setLink(top);
		top = nptr;
		size++;
	}
	
	//Removes and returns the top element of the stack
	public int[] pop() {
		int d[] = top.getData();
		top = top.getLink();
		size--;
		return d;
		
	}
	
	//Method to return the reference of top element, but does not remove it
	public int[] peek() {
		int d[] = top.getData();
		return d;
	}
}

class Node {
	int datax;
	int datay;
	Node link;

	public Node() {
		datax = -1;
		datay = -1;
		link = null;
	}
	public Node (int datax, int datay) {
		this.datax = datax;
		this.datay = datay;
		this.link = null;
	}
	public Node (int datax, int datay, Node link) {
		this.datax = datax;
		this.datay = datay;
		this.link = link;
	}
	public void setLink(Node node) {
		this.link = node;
	}
	public void setData(int data1, int data2) {
		this.datax = data1;
		this.datay = data2;
	}
	public Node getLink() {
		return link;
	}
	public int[] getData() {
		int[] array = new int[2];
		array[0] = this.datax;
		array[1] = this.datay;
		return array;
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




