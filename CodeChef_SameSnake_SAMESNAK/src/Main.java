import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author Sarthak Goyal
 * 22-May-2017 3:10:20 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				String input1tmp = br.readLine();		//snake 1
				String input2tmp = br.readLine();		//snake 2
				String[] input1 = input1tmp.split(" ");	//x11, y11, x12, y12
				String[] input2 = input2tmp.split(" ");	//x21, y21, x22, y22
				int x11 = Integer.parseInt(input1[0]);
				int y11 = Integer.parseInt(input1[1]);
				int x12 = Integer.parseInt(input1[2]);
				int y12 = Integer.parseInt(input1[3]);
				int x21 = Integer.parseInt(input2[0]);
				int y21 = Integer.parseInt(input2[1]);
				int x22 = Integer.parseInt(input2[2]);
				int y22 = Integer.parseInt(input2[3]);
				boolean horizontal1 = true;
				boolean horizontal2 = true;
				boolean ans = true;
				if (y11 == y12) {
					horizontal1 = true;
				} else {
					horizontal1 = false;
				}
				
				if (y21 == y22) {
					horizontal2 = true;
				} else {
					horizontal2 = false;
				}
				
				if ((horizontal1) && (horizontal2)) {
					if (y11 == y21) {
						// make smaller the first coordinate
						if (x11 > x12) {
							int tmp = x11;
							x11 = x12;
							x12 = tmp;
						}
						
						if (x21 > x22) {
							int tmp = x21;
							x21 = x22;
							x22 = tmp;
						}
						
						int smallx1 = x11;
						int smallx2 = x12;
						int otherx1 = x21;
						int otherx2 = x22;
						if (x21 < x11) {
							smallx1 = x21;
							smallx2 = x22;
							otherx1 = x11;
							otherx2 = x12;
						}
						
						if (smallx2 < otherx1) {
							ans = false;
							System.out.println("no");
							continue;
						}
						
					} else {
						ans = false;
						System.out.println("no");
						continue;
					}
				}	else if ((horizontal1 == false) && (horizontal2 == false)) {
					if (x11 == x21) {
						// make smaller the first coordinate
						if (y11 > y12) {
							int tmp = y11;
							y11 = y12;
							y12 = tmp;
						}
						
						if (y21 > y22) {
							int tmp = y21;
							y21 = y22;
							y22 = tmp;
						}
						
						int smally1 = y11;
						int smally2 = y12;
						int othery1 = y21;
						int othery2 = y22;
						
						if (y21 < y11) {
							smally1 = y21;
							smally2 = y22;
							othery1 = y11;
							othery2 = y12;
						}
						
						if (smally2 < othery1) {
							ans = false;
							System.out.println("no");
							continue;
							
						}
						
					} else {
						ans = false;
						System.out.println("no");
						continue;
					}
				}	else {
					if (((x11 == x21) && (y11 == y21)) || ((x11 == x22) && (y11 == y22)) || ((x12 == x21) && (y12 == y21)) || ((x12 == x22) && (y12 == y22))) {
						ans = true;
						System.out.println("yes");
						continue;
					} else {
						ans = false;
						System.out.println("no");
						continue;
					}
				}
				
				if (ans == true) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

